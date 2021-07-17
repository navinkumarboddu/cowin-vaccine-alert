package org.cowin.data;

import java.util.List;

public class SelFindByPinData {
	public List<SelSessions> sessions;

	@Override
	public String toString() {
		return "FinByPinData [sessions=" + sessions + "]";
	}

	public SelFindByPinData(List<SelSessions> slots) {
		super();
		this.sessions = slots;
	}

}
