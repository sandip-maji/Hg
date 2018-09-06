package com.org.ecom.model;

import java.util.ArrayList;
import java.util.List;

public class HgModel {
	
	private String id;
	private String bookingId;
	private List<HotelModel> hotelDetails;
	private GuestInfoModel guestInfo;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public List<HotelModel> getHotelDetails() {
		if(null==hotelDetails) {
			hotelDetails = new ArrayList<>();
		}
		return hotelDetails;
	}
	public void setHotelDetails(List<HotelModel> hotelDetails) {
		this.hotelDetails = hotelDetails;
	}
	public GuestInfoModel getGuestInfo() {
		return guestInfo;
	}
	public void setGuestInfo(GuestInfoModel guestInfo) {
		this.guestInfo = guestInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
