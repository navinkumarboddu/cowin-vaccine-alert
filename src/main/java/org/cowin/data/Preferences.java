package org.cowin.data;

import java.util.List;

public class Preferences {
	private List<Dose> doses;

	private List<Vaccine> vaccines;

	private List<Age> ages;

	public List<Dose> getDoses() {
		return doses;
	}

	public void setDoses(List<Dose> doses) {
		this.doses = doses;
	}

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public List<Age> getAges() {
		return ages;
	}

	public void setAges(List<Age> ages) {
		this.ages = ages;
	}

	@Override
	public String toString() {
		return "ClassPojo [doses = " + doses + ", vaccines = " + vaccines + ", ages = " + ages + "]";
	}
}