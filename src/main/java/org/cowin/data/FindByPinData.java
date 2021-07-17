package org.cowin.data;

import java.util.List;

public class FindByPinData {
	public List<Session> sessions;

	@Override
	public String toString() {
		return "FinByPinData [sessions=" + sessions + "]";
	}

	public FindByPinData(List<Session> slots) {
		super();
		this.sessions = slots;
	}

}
