package com.org.ecom.model;

import java.util.List;

public class GuestInfoModel {
	

	private String noOfPax;
	private List<UserModel> paxInfo;
	public String getNoOfPax() {
		return noOfPax;
	}
	public void setNoOfPax(String noOfPax) {
		this.noOfPax = noOfPax;
	}
	public List<UserModel> getPaxInfo() {
		return paxInfo;
	}
	public void setPaxInfo(List<UserModel> paxInfo) {
		this.paxInfo = paxInfo;
	}

	
}
