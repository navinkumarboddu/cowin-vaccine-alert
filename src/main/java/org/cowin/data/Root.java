package org.cowin.data;

import java.util.List;

public class Root {
	public List<Session> session;

	@Override
	public String toString() {
		return "Root [sessions=" + session + "]";
	}

	public List<Session> getSessions() {
		return session;
	}

	public void setSessions(List<Session> session) {
		this.session = session;
	}

}