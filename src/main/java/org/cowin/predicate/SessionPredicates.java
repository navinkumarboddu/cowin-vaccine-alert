package org.cowin.predicate;

import java.util.List;
import java.util.function.Predicate;

import org.cowin.data.Age;
import org.cowin.data.Dose;
import org.cowin.data.SelSessions;
import org.cowin.data.Vaccine;

public class SessionPredicates {

	public static Predicate<SelSessions> ageCriteria(List<Age> ages) {
		return p -> ages.stream().filter(age -> age.isStatus())
				.anyMatch(age -> age.getAge() >= Long.valueOf(p.getMin_age_limit()));
	}

	public static Predicate<SelSessions> vaccineCriteria(List<Vaccine> vaccines) {
		return p -> vaccines.stream().filter(vaccine -> vaccine.isStatus())
				.anyMatch(vaccine -> p.getVaccine().equalsIgnoreCase(vaccine.getVaccinename()));
	}

	public static Predicate<SelSessions> doseCriteria(List<Dose> doses) {
		return p -> doses.stream().filter(dose -> dose.isStatus()).anyMatch(dose -> dose.isStatus()
				&& (p.getAvailable_capacity_dose1() > 0 || p.getAvailable_capacity_dose2() > 0));
	}
}