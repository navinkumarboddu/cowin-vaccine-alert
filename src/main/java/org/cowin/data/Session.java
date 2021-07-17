package org.cowin.data;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;

public class Session {
	public int center_id;
	public String name;
	public String name_l;
	public String state_name;
	public String state_name_l;
	public String district_name;
	public String district_name_l;
	public String block_name;
	public String block_name_l;
	public String pincode;
	public double lat;

	@JsonbProperty("long")
	public double longe;
	public String from;
	public String to;
	public String fee_type;
	public String fee;
	public String session_id;
	public String date;
	public int available_capacity;
	public int available_capacity_dose1;
	public int available_capacity_dose2;
	public int min_age_limit;
	public String vaccine;
	public List<String> slots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}

	public int getMin_age_limit() {
		return min_age_limit;
	}

	public void setMin_age_limit(int min_age_limit) {
		this.min_age_limit = min_age_limit;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public int getAvailable_capacity_dose1() {
		return available_capacity_dose1;
	}

	public void setAvailable_capacity_dose1(int available_capacity_dose1) {
		this.available_capacity_dose1 = available_capacity_dose1;
	}

	public int getAvailable_capacity_dose2() {
		return available_capacity_dose2;
	}

	public void setAvailable_capacity_dose2(int available_capacity_dose2) {
		this.available_capacity_dose2 = available_capacity_dose2;
	}
}