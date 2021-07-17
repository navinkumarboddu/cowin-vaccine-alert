package org.cowin.data;

public class CalendarByPin {
	private Centers[] centers;

	public Centers[] getCenters() {
		return centers;
	}

	public void setCenters(Centers[] centers) {
		this.centers = centers;
	}

	@Override
	public String toString() {
		return "ClassPojo [centers = " + centers + "]";
	}
}
