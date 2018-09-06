package com.org.ecom.model;

import java.util.ArrayList;
import java.util.List;

public class GuestInfoModel {
	

	private String id;
	private String noOfPax;
	private List<UserModel> paxInfo;
	public String getNoOfPax() {
		return noOfPax;
	}
	public void setNoOfPax(String noOfPax) {
		this.noOfPax = noOfPax;
	}
	public List<UserModel> getPaxInfo() {
		if(null==paxInfo) {
			paxInfo = new ArrayList<>();
		}
		return paxInfo;
	}
	public void setPaxInfo(List<UserModel> paxInfo) {
		this.paxInfo = paxInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
}
