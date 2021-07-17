package org.cowin.data;

import javax.json.bind.annotation.JsonbProperty;

public class SelSessions {
	private String date;

	private String pincode;

	private String address;

	private String min_age_limit;

	private String max_age_limit;

	private String fee;

	private String session_id;

	private String fee_type;

	private String available_capacity;

	@JsonbProperty("long")
	private String longe;

	private String district_name;

	private String block_name;

	private String vaccine;

	private String[] slots;

	private String center_id;

	private String state_name;

	private String name;

	private String from;

	private String to;

	private String available_capacity_dose2;

	private String lat;

	private String available_capacity_dose1;

	public boolean isAllow_all_age() {
		return allow_all_age;
	}

	public void setAllow_all_age(boolean allow_all_age) {
		this.allow_all_age = allow_all_age;
	}

	private boolean allow_all_age;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMin_age_limit() {
		return min_age_limit;
	}

	public void setMin_age_limit(String min_age_limit) {
		this.min_age_limit = min_age_limit;
	}

	public String getMax_age_limit() {
		return max_age_limit;
	}

	public void setMax_age_limit(String max_age_limit) {
		this.max_age_limit = max_age_limit;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(String available_capacity) {
		this.available_capacity = available_capacity;
	}

	public String getLonge() {
		return longe;
	}

	public void setLonge(String longe) {
		this.longe = longe;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String[] getSlots() {
		return slots;
	}

	public void setSlots(String[] slots) {
		this.slots = slots;
	}

	public String getCenter_id() {
		return center_id;
	}

	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAvailable_capacity_dose2() {
		return available_capacity_dose2;
	}

	public void setAvailable_capacity_dose2(String available_capacity_dose2) {
		this.available_capacity_dose2 = available_capacity_dose2;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getAvailable_capacity_dose1() {
		return available_capacity_dose1;
	}

	public void setAvailable_capacity_dose1(String available_capacity_dose1) {
		this.available_capacity_dose1 = available_capacity_dose1;
	}

	@Override
	public String toString() {
		return "ClassPojo [date = " + date + ", pincode = " + pincode + ", address = " + address + ", min_age_limit = "
				+ min_age_limit + ", fee = " + fee + ", session_id = " + session_id + ", fee_type = " + fee_type
				+ ", available_capacity = " + available_capacity + ", long = " + longe + ", district_name = "
				+ district_name + ", block_name = " + block_name + ", vaccine = " + vaccine + ", slots = " + slots
				+ ", center_id = " + center_id + ", state_name = " + state_name + ", name = " + name + ", from = "
				+ from + ", to = " + to + ", available_capacity_dose2 = " + available_capacity_dose2 + ", lat = " + lat
				+ ", available_capacity_dose1 = " + available_capacity_dose1 + "]";
	}
}