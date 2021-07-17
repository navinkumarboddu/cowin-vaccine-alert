package org.cowin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cowin.data.CowinPincodes;
import org.cowin.data.FindByPinData;
import org.cowin.data.SelCalendarByPin;
import org.cowin.data.SelCenters;
import org.cowin.data.SelFindByPinData;
import org.cowin.data.SelRoot;
import org.cowin.data.SelSessions;
import org.cowin.data.Session;
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
		// String strDate = formDate.format(new Date(new Date().getTime() + (1000 * 60 *
		// 60 * 24)));
		List<SelSessions> slots = new ArrayList<>();
		List<String> pincodes = new ArrayList<String>();
		try (Stream<CowinPincodes> persons = CowinPincodes.streamAll()) {
			pincodes = persons.map(p -> p.getPincode().toLowerCase()).collect(Collectors.toList());
			// System.out.println(pincodes);
		}

		pincodes.stream().filter(e -> e != null).forEach(e -> {
			SelRoot rootData = cowinService.getSessionSlotFindByPin(e, strDate);
			if (rootData.getSessions().length > 0) {
				// Jsonb jsonb = JsonbBuilder.create();
				// String jsonString = jsonb.toJson(rootData);
				// System.out.println(jsonString);
				slots.addAll(Arrays.asList(rootData.getSessions()));
			}
		});
		List<SelSessions> finalSlots = slots.stream().filter(e -> e.getVaccine().equalsIgnoreCase("covishield"))
				.filter(e -> Integer.parseInt(e.getMin_age_limit()) < 45)
				.filter(e -> Integer.parseInt(e.getAvailable_capacity_dose1()) > 10).collect(Collectors.toList());
		// return new SelFindByPinData(finalSlots);

		// Create Jsonb and serialize
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(new SelFindByPinData(finalSlots));
		System.out.println("Navin : " + result);

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

}
