package com.org.ecom.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.org.ecom.model.DateTimeModel;
import com.org.ecom.model.GuestInfoModel;
import com.org.ecom.model.HgModel;
import com.org.ecom.model.HotelModel;
import com.org.ecom.model.RoomModel;
import com.org.ecom.model.UserModel;

@Component("commonUtil")
public class CommonUtil {

	public HgModel getMockHgModelByBookingId(String bookedId) {

		HgModel hgModel = new HgModel();

		hgModel.setBookingId(bookedId);

		HotelModel hotelModel = new HotelModel();
		List<HotelModel> hotelDetails = new ArrayList<>();

		hotelModel.setName("TAJ");
		hotelModel.setAddress("Apollo Bunder Mumbai Maharashtra India 400 001");
		hotelModel.setHotelId("001");
		hotelModel.setContact("+91 22 6665 3366, +91 22 6665 0300");
		hotelModel.setEmail("tmhbc.bom@tajhotels.com");
		hotelModel.setStarRate("5");

		List<String> amenity = new ArrayList<>();
		amenity.add("WIFI");
		amenity.add("Pool");
		amenity.add("Spa");
		amenity.add("Parking");
		amenity.add("Restaurant");
		hotelModel.setAmenity(amenity);

		DateTimeModel checkInOut = new DateTimeModel();
		checkInOut.setTime("10:00");
		hotelModel.setDefaultCheckIn(checkInOut);

		checkInOut = new DateTimeModel();
		checkInOut.setTime("09:00");
		hotelModel.setDefaultCheckOut(checkInOut);

		checkInOut = new DateTimeModel();
		checkInOut.setDate("10/09/2018");
		checkInOut.setTime("11:00");
		hotelModel.setUserCheckIn(checkInOut);

		checkInOut = new DateTimeModel();
		checkInOut.setDate("20/09/2018");
		checkInOut.setTime("08:00");
		hotelModel.setUserCheckOut(checkInOut);

		hotelModel.setCheckedOut(false);

		GuestInfoModel gustInfoModel = new GuestInfoModel();

		gustInfoModel.setNoOfPax("2");

		UserModel userModel = new UserModel();
		List<UserModel> paxInfo = new ArrayList<>();

		userModel.setAge("31");
		userModel.setDob("24/06/1987");
		userModel.setFname("Lionel");
		userModel.setMname("Andres");
		userModel.setLname("Messi");
		userModel.setTitle("Cuccittini");

		userModel.setAddress("Avinguda de Bellamar 08860 Castelldefels, Barcelona, Spain ");

		userModel.setFoodType("Non-Veg");
		userModel.setInterest("Football");
		userModel.setMainUser(true);
		userModel.setReligion("Devout Catholic");
		userModel.setContact("+34 93 496 36 00");
		userModel.setEcontact("premsa@fcbarcelona.cat");
		userModel.setGender("M");
		userModel.setEmail("leomessi@fcb.com");
		userModel.setMaritalStatus("Married ");

		paxInfo.add(userModel);

		userModel = new UserModel();

		userModel.setAge("30");
		userModel.setDob("26/02/1988");
		userModel.setFname("Antonella ");
		// userModel.setMname("Andres");
		userModel.setLname("Roccuzzo");
		// userModel.setTitle("Cuccittini");

		userModel.setAddress("Avinguda de Bellamar 08860 Castelldefels, Barcelona, Spain ");

		userModel.setFoodType("Non-Veg");
		userModel.setInterest("Modeling");
		userModel.setMainUser(true);
		userModel.setReligion("Devout Catholic");
		userModel.setContact("+34 93 496 36 00");
		userModel.setEcontact("premsa@fcbarcelona.cat");
		userModel.setGender("M");
		userModel.setEmail("leomessi@fcb.com");
		userModel.setMaritalStatus("Married ");

		paxInfo.add(userModel);

		gustInfoModel.setPaxInfo(paxInfo);

		hgModel.setGuestInfo(gustInfoModel);

		hotelDetails.add(hotelModel);
		hgModel.setHotelDetails(hotelDetails);

		return hgModel;

	}

	public HgModel getValidateId(String bookedId) {
		HgModel hgModel = getMockHgModelByBookingId(bookedId);

		int i = 0;
		for (HotelModel hotel : hgModel.getHotelDetails()) {
			hotel.setWebCheckedIn(true);
			hotel.setCheckInRefId(bookedId+"-"+i++);
		}
		return hgModel;
	}

	public RoomModel getRoomDetails(String hotelId, String bookedId) {

		RoomModel roomModel = new RoomModel();

		roomModel.setFloor("2");
		roomModel.setRoomId("1");
		roomModel.setRoomNo("100");
		roomModel.setSize("580 Sq. Ft.");

		List<String> roomFace = new ArrayList<>();
		roomFace.add("Climate control");
		roomFace.add("WIFI");
		roomFace.add("Fridge");

		roomModel.setAmenity(roomFace);

		roomFace = new ArrayList<>();
		roomFace.add("24*7 Support");
		roomFace.add("Iconic rooms and suites");

		roomModel.setService(roomFace);

		roomFace = new ArrayList<>();
		roomFace.add("Scenic views of the runway");

		roomModel.setView(roomFace);

		return roomModel;

	}

}
