package org.cowin.data;

public class SelRoot {
	private SelSessions[] sessions;

	public SelSessions[] getSessions() {
		return sessions;
	}

	public void setSessions(SelSessions[] sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "ClassPojo [sessions = " + sessions + "]";
	}
}