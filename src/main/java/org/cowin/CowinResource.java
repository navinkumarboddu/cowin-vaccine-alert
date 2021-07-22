package org.cowin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cowin.data.Age;
import org.cowin.data.CowinPincodes;
import org.cowin.data.Dose;
import org.cowin.data.FindByPinData;
import org.cowin.data.Preferences;
import org.cowin.data.SelCalendarByPin;
import org.cowin.data.SelCenters;
import org.cowin.data.SelRoot;
import org.cowin.data.SelSessions;
import org.cowin.data.Session;
import org.cowin.data.Vaccine;
import org.cowin.predicate.SessionPredicates;
import org.cowin.repository.CowinPincodeRepository;
import org.cowin.service.CowinDataConverter;
import org.cowin.service.CowinPinCodesService;
import org.cowin.service.CowinSeleniumService;

@Path("/cowin")
public class CowinResource {

	@Inject
	CowinSeleniumService cowinService;

	@Inject
	CowinPinCodesService cowinPinCodesService;

	@Inject
	CowinPincodeRepository cowinPincodeRepository;

	@GET
	@Path("/findByPin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SelSessions> getSessionSlotFindByPin() {
		SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formDate.format(new Date());
		List<SelSessions> slots = new ArrayList<>();
		List<String> pincodes = new ArrayList<String>();
		try (Stream<CowinPincodes> persons = CowinPincodes.streamAll()) {
			pincodes = persons.map(p -> p.getPincode().toLowerCase()).collect(Collectors.toList());
		}

		pincodes.stream().filter(e -> e != null).forEach(e -> {
			SelRoot rootData = cowinService.getSessionSlotFindByPin(e, strDate);
			if (rootData.getSessions().length > 0) {
				slots.addAll(Arrays.asList(rootData.getSessions()));
			}
		});

		List<SelSessions> finalSlots = filterEmployees(slots, SessionPredicates.ageCriteria(getAges()));
		finalSlots = filterEmployees(finalSlots, SessionPredicates.vaccineCriteria(getVaccines()));
		finalSlots = filterEmployees(finalSlots, SessionPredicates.doseCriteria(getDoses()));

		/*
		 * List<SelSessions> finalSlots = slots.stream().filter(e ->
		 * e.getVaccine().equalsIgnoreCase("covishield")) .filter(e ->
		 * Integer.parseInt(e.getMin_age_limit()) < 45) .filter(e ->
		 * e.getAvailable_capacity_dose1() > 10).collect(Collectors.toList());
		 */
		// return new SelFindByPinData(finalSlots);

		// Create Jsonb and serialize
		/*
		 * Jsonb jsonb = JsonbBuilder.create(); String result = jsonb.toJson(new
		 * SelFindByPinData(finalSlots));
		 */
		// System.out.println("Navin : " + result);

		return finalSlots;
	}

	@GET
	@Path("/calendarByPin")
	@Produces(MediaType.APPLICATION_JSON)
	public FindByPinData getSessionSlotCalendarByPin() {
		SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formDate.format(new Date());
		List<Session> slots = new ArrayList<Session>();
		List<String> pincodes = new ArrayList<String>();
		try (Stream<CowinPincodes> persons = CowinPincodes.streamAll()) {
			pincodes = persons.map(p -> p.getPincode().toLowerCase()).collect(Collectors.toList());
			// System.out.println(pincodes);
		}

		pincodes.stream().filter(e -> e != null).forEach(e -> {
			SelCalendarByPin s = cowinService.getSessionSlotCalendarByPin(e, strDate);
			if (s.getCenters().length > 0) {
				// Jsonb jsonb = JsonbBuilder.create();
				// String jsonString = jsonb.toJson(rootData);
				// System.out.println(jsonString);
				List<SelCenters> centersList = Arrays.asList(s.getCenters());
				Function<SelCenters, List<Session>> converter = new CowinDataConverter();
				for (SelCenters centerss : centersList) {
					slots.addAll(converter.apply(centerss));
				}
			}
		});

		List<Session> finalSlots = slots.stream().filter(e -> e.getVaccine().equalsIgnoreCase("covishield"))
				.filter(e -> e.getMin_age_limit() < 45).filter(e -> e.getAvailable_capacity_dose1() > 10)
				.collect(Collectors.toList());
		return new FindByPinData(finalSlots);
	}

	public static <X, Y, Z> Map<X, Z> transform(Map<X, Y> input, Function<Y, Z> function) {
		return input.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> function.apply(entry.getValue())));
	}

	@GET
	@Path("/pincodes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CowinPincodes> getPinCodes() {
		List<CowinPincodes> result = new ArrayList<CowinPincodes>();
		try (Stream<CowinPincodes> cowinPincodes = CowinPincodes.streamAll();) {
			result = cowinPincodes.collect(Collectors.toList());
		}
		return result;
	}

	@POST
	@Path("/pincodes")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getPinCodes(CowinPincodes cowinPincodes) {
		CowinPincodes.persist(cowinPincodes);
		return Response.accepted().build();
	}

	@DELETE
	@Path("/pincodes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response deleteTodo(@PathParam(value = "id") long id) {
		boolean deleted = CowinPincodes.deleteById(id);
		if (deleted) {
			System.out.println("Deleted");
			return Response.accepted().build();
		}
		return Response.serverError().build();
	}

	@GET
	@Path("/ages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Age> getAges() {
		List<Age> result = new ArrayList<Age>();
		try (Stream<Age> ages = Age.streamAll();) {
			result = ages.collect(Collectors.toList());
		}
		return result;
	}

	@POST
	@Path("/ages")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Age addAge(Age age) {
		age.setId(null);
		Age.persist(age);
		return age;
	}

	@GET
	@Path("/vaccines")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vaccine> getVaccines() {
		List<Vaccine> result = new ArrayList<Vaccine>();
		try (Stream<Vaccine> vaccines = Vaccine.streamAll();) {
			result = vaccines.collect(Collectors.toList());
		}
		return result;
	}

	@POST
	@Path("/vaccines")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Vaccine addVaccine(Vaccine vaccine) {
		vaccine.setId(null);
		Vaccine.persist(vaccine);
		return vaccine;
	}

	@GET
	@Path("/doses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Dose> getDoses() {
		List<Dose> result = new ArrayList<Dose>();
		try (Stream<Dose> doses = Dose.streamAll();) {
			result = doses.collect(Collectors.toList());
		}
		return result;
	}

	@POST
	@Path("/preferences")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addPreference(Preferences preferences) {
		Age.update("status", false);
		for (Age age : preferences.getAges()) {
			Age.update("status=" + age.isStatus() + " where age = ?1 and id=?2", age.getAge(), age.getId());
		}
		Vaccine.update("status", false);
		for (Vaccine vaccine : preferences.getVaccines()) {
			Vaccine.update("status=" + vaccine.isStatus() + " where vaccinename = ?1 and id=?2",
					vaccine.getVaccinename(), vaccine.getId());
		}
		Dose.update("status", false);
		for (Dose dose : preferences.getDoses()) {
			Dose.update("status=" + true + " where dose = ?1 and id=?2", dose.getDose(), dose.getId());
		}
		return Response.accepted().build();
	}

	public static List<SelSessions> filterEmployees(List<SelSessions> slots, Predicate<SelSessions> predicate) {
		return slots.stream().filter(predicate).collect(Collectors.<SelSessions>toList());
	}
}
