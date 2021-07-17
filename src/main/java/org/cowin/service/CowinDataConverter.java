package org.cowin.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.cowin.data.SelCalenderByPinSessions;
import org.cowin.data.SelCenters;
import org.cowin.data.Session;

public class CowinDataConverter implements Function<SelCenters, List<Session>> {

	@Override
	public List<Session> apply(SelCenters t) {
		List<SelCalenderByPinSessions> sessionsList = Arrays.asList(t.getSessions());
		List<Session> sessionList = sessionsList.stream().map(temp -> {
			Session session = new Session();
			session.setName(t.getName());
			session.setBlock_name(t.getBlock_name());
			session.setPincode(t.getPincode());
			session.setAvailable_capacity(Integer.parseInt(temp.getAvailable_capacity()));
			session.setVaccine(temp.getVaccine());
			session.setDate(temp.getDate());
			session.setMin_age_limit(Integer.parseInt(temp.getMin_age_limit()));
			return session;
		}).collect(Collectors.toList());
		return sessionList;
	}

}
