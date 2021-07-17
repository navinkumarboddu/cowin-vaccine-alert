package org.cowin.data;

public class MobileData {
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ClassPojo [mobile = " + mobile + "]";
	}

	public MobileData(String mobile) {
		super();
		this.mobile = mobile;
	}

}