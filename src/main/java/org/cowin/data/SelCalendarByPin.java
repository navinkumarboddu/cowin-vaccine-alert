package org.cowin.data;

public class SelCalendarByPin {
	private SelCenters[] centers;

	public SelCenters[] getCenters() {
		return centers;
	}

	public void setCenters(SelCenters[] centers) {
		this.centers = centers;
	}

	@Override
	public String toString() {
		return "ClassPojo [centers = " + centers + "]";
	}
}
