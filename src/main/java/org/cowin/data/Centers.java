package org.cowin.data;

import javax.json.bind.annotation.JsonbProperty;

public class Centers {
	private String address_l;

	private String pincode;

	private Sessions[] sessions;

	private String address;

	private Vaccine_fees[] vaccine_fees;

	private String district_name_l;

	private String name_l;

	private String fee_type;

	private String state_name_l;

	@JsonbProperty("long")
	private String longe;

	private String district_name;

	private String block_name;

	private String block_name_l;

	private String center_id;

	private String state_name;

	private String name;

	private String from;

	private String to;

	private String lat;

	public String getAddress_l() {
		return address_l;
	}

	public void setAddress_l(String address_l) {
		this.address_l = address_l;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Sessions[] getSessions() {
		return sessions;
	}

	public void setSessions(Sessions[] sessions) {
		this.sessions = sessions;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Vaccine_fees[] getVaccine_fees() {
		return vaccine_fees;
	}

	public void setVaccine_fees(Vaccine_fees[] vaccine_fees) {
		this.vaccine_fees = vaccine_fees;
	}

	public String getDistrict_name_l() {
		return district_name_l;
	}

	public void setDistrict_name_l(String district_name_l) {
		this.district_name_l = district_name_l;
	}

	public String getName_l() {
		return name_l;
	}

	public void setName_l(String name_l) {
		this.name_l = name_l;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getState_name_l() {
		return state_name_l;
	}

	public void setState_name_l(String state_name_l) {
		this.state_name_l = state_name_l;
	}

	public String getlonge() {
		return longe;
	}

	public void setlonge(String longe) {
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

	public String getBlock_name_l() {
		return block_name_l;
	}

	public void setBlock_name_l(String block_name_l) {
		this.block_name_l = block_name_l;
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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "ClassPojo [address_l = " + address_l + ", pincode = " + pincode + ", sessions = " + sessions
				+ ", address = " + address + ", vaccine_fees = " + vaccine_fees + ", district_name_l = "
				+ district_name_l + ", name_l = " + name_l + ", fee_type = " + fee_type + ", state_name_l = "
				+ state_name_l + ", long = " + longe + ", district_name = " + district_name + ", block_name = "
				+ block_name + ", block_name_l = " + block_name_l + ", center_id = " + center_id + ", state_name = "
				+ state_name + ", name = " + name + ", from = " + from + ", to = " + to + ", lat = " + lat + "]";
	}
}