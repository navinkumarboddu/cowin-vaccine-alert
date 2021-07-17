package org.cowin.data;

public class Vaccine_fees {
	private String vaccine;

	private String fee;

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "ClassPojo [vaccine = " + vaccine + ", fee = " + fee + "]";
	}
}