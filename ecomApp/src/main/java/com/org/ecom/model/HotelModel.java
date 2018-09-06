package com.org.ecom.model;

import java.util.List;

public class HotelModel {
	
	
	private String id;
	private String starRate;
	private List<String> amenity;
	private String hotelId;
	private String name;
	private String address;
	private String contact;
	private String email;
	
	private boolean hotelCheckedIn;
	private String checkInRefId;
	private boolean webCheckedIn;
	private boolean feedbackEnabled;
	
	
	private boolean checkedOut;
	
	private DateTimeModel defaultCheckIn;
	private DateTimeModel defaultCheckOut;
	
	private DateTimeModel userCheckIn;
	private DateTimeModel userCheckOut;
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public DateTimeModel getDefaultCheckIn() {
		return defaultCheckIn;
	}
	public void setDefaultCheckIn(DateTimeModel defaultCheckIn) {
		this.defaultCheckIn = defaultCheckIn;
	}
	public DateTimeModel getDefaultCheckOut() {
		return defaultCheckOut;
	}
	public void setDefaultCheckOut(DateTimeModel defaultCheckOut) {
		this.defaultCheckOut = defaultCheckOut;
	}
	public String getStarRate() {
		return starRate;
	}
	public void setStarRate(String starRate) {
		this.starRate = starRate;
	}
	public List<String> getAmenity() {
		return amenity;
	}
	public void setAmenity(List<String> amenity) {
		this.amenity = amenity;
	}
	public DateTimeModel getUserCheckIn() {
		return userCheckIn;
	}
	public void setUserCheckIn(DateTimeModel userCheckIn) {
		this.userCheckIn = userCheckIn;
	}
	public DateTimeModel getUserCheckOut() {
		return userCheckOut;
	}
	public void setUserCheckOut(DateTimeModel userCheckOut) {
		this.userCheckOut = userCheckOut;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	public boolean isHotelCheckedIn() {
		return hotelCheckedIn;
	}
	public void setHotelCheckedIn(boolean hotelCheckedIn) {
		this.hotelCheckedIn = hotelCheckedIn;
	}
	public String getCheckInRefId() {
		return checkInRefId;
	}
	public void setCheckInRefId(String checkInRefId) {
		this.checkInRefId = checkInRefId;
	}
	public boolean isWebCheckedIn() {
		return webCheckedIn;
	}
	public void setWebCheckedIn(boolean webCheckedIn) {
		this.webCheckedIn = webCheckedIn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isFeedbackEnabled() {
		return feedbackEnabled;
	}
	public void setFeedbackEnabled(boolean feedbackEnabled) {
		this.feedbackEnabled = feedbackEnabled;
	}
	

}
