package com.org.ecom.model;

import java.util.List;

public class HgModel {
	
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
	

}
