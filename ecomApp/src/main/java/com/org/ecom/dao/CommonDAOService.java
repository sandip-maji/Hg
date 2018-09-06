package com.org.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.ecom.model.DateTimeModel;
import com.org.ecom.model.GuestInfoModel;
import com.org.ecom.model.HgModel;
import com.org.ecom.model.HotelModel;
import com.org.ecom.model.UserModel;

@Repository
public class CommonDAOService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<UserModel> getUsersById(String id) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM USER where id='" + id+"'");
		List<UserModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			UserModel user = new UserModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setFname((String) row.get("fname"));
			user.setAddress((String) row.get("address"));
			user.setAge((String) row.get("age"));
			user.setContact((String) row.get("contact"));
			user.setDob((String) row.get("dob"));
			user.setEcontact((String) row.get("econtact"));
			user.setEmail((String) row.get("email"));
			user.setFoodType((String) row.get("foodType"));
			user.setGender((String) row.get("gender"));
			user.setInitial((String) row.get("initial"));
			user.setInterest((String) row.get("interest"));
			user.setLname((String) row.get("lname"));
			user.setMainUser((boolean) row.get("mainUser"));
			user.setMaritalStatus((String) row.get("maritalStatus"));
			user.setMname((String) row.get("mname"));
			user.setOthers((String) row.get("others"));
			user.setReligion((String) row.get("religion"));
			user.setTitle((String) row.get("title"));

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}

	public List<DateTimeModel> getDateTimeById(String id) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM DateTime where id='" + id+"'");
		List<DateTimeModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			DateTimeModel user = new DateTimeModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setDate((String) row.get("date"));
			user.setTime((String) row.get("time"));

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}

	public List<GuestInfoModel> getGuestInfoById(String id) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM GuestInfo where id='" + id+"'");
		List<GuestInfoModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			GuestInfoModel user = new GuestInfoModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setNoOfPax((String) row.get("noOfPax"));

			String paxInfo = (String) row.get("paxInfo");

			if (null != paxInfo) {
				for (String paxId : paxInfo.split(",")) {
					List<com.org.ecom.model.UserModel> userModel = getUsersById(paxId);
					if (null != userModel && !userModel.isEmpty()) {
						user.getPaxInfo().add(userModel.stream().findFirst().get());
					}
				}
			}

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}

	public List<HotelModel> getHotelModelById(String id) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Hotel where id='" + id+"'");
		List<HotelModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			HotelModel user = new HotelModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setAddress((String) row.get("address"));
			// user.setAmenity(amenity);
			user.setCheckedOut((boolean) row.get("checkedOut"));
			user.setCheckInRefId((String) row.get("checkInRefId"));
			user.setContact((String) row.get("contact"));

			List<DateTimeModel> dateTime = getDateTimeById((String) row.get("defaultCheckIn"));
			if (null != dateTime && !dateTime.isEmpty()) {
				user.setDefaultCheckIn(dateTime.stream().findFirst().get());
			}

			dateTime = getDateTimeById((String) row.get("defaultCheckOut"));
			if (null != dateTime && !dateTime.isEmpty()) {
				user.setDefaultCheckOut(dateTime.stream().findFirst().get());
			}

			user.setEmail((String) row.get("email"));
			user.setHotelCheckedIn((boolean) row.get("hotelCheckedIn"));
			user.setHotelId((String) row.get("hotelId"));
			user.setName((String) row.get("name"));
			;
			user.setStarRate((String) row.get("starRate"));

			dateTime = getDateTimeById((String) row.get("userCheckIn"));
			if (null != dateTime && !dateTime.isEmpty()) {
				user.setUserCheckIn(dateTime.stream().findFirst().get());
			}
			dateTime = getDateTimeById((String) row.get("userCheckOut"));
			if (null != dateTime && !dateTime.isEmpty()) {
				user.setUserCheckOut(dateTime.stream().findFirst().get());
			}
			user.setWebCheckedIn((boolean) row.get("webCheckedIn"));
			
			if(null!=row.get("feedbackEnabled")) {
				user.setFeedbackEnabled((boolean) row.get("feedbackEnabled"));
			}
			

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}

	public List<HgModel> getHgById(String bookingId) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Hg where bookingId='" + bookingId+"'");
		List<HgModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			HgModel user = new HgModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setBookingId(bookingId);
			String hotelDetails = (String) row.get("hotelDetails");

			if (null != hotelDetails) {
				for (String hotelId : hotelDetails.split(",")) {
					List<HotelModel> userModel = getHotelModelById(hotelId);
					if (null != userModel && !userModel.isEmpty()) {
						user.getHotelDetails().add(userModel.stream().findFirst().get());
					}
				}
			}
			
			List<GuestInfoModel> guestInfo = getGuestInfoById((String) row.get("guestInfo"));
			if (null != guestInfo && !guestInfo.isEmpty()) {
				user.setGuestInfo(guestInfo.stream().findFirst().get());
			}

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}
	
	
	
	public List<HgModel> getHgCheckInById(String bookingId,String hotId) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Hg where bookingId='" + bookingId+"'");
		List<HgModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			HgModel user = new HgModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setBookingId(bookingId);
			String hotelDetails = (String) row.get("hotelDetails");

			if (null != hotelDetails) {
				for (String hotelId : hotelDetails.split(",")) {
					List<HotelModel> userModel = getHotelModelById(hotelId);
					if (null != userModel && !userModel.isEmpty()) {
						
						for(HotelModel hotel : userModel) {
							if(null!=hotel && hotel.getHotelId().equalsIgnoreCase(hotId)) {
								user.getHotelDetails().add(hotel);
								user.getHotelDetails().stream().findFirst().get().setWebCheckedIn(true);
								user.getHotelDetails().stream().findFirst().get().setCheckInRefId(bookingId+"_"+hotId+"_"+hotel.getUserCheckIn().getDate());
							
							
								updateHotelForWebCheckin(user.getHotelDetails().stream().findFirst().get().getId(), 
										user.getHotelDetails().stream().findFirst().get().getCheckInRefId(),true);
							
							}
						}
						
					}
				}
			}
			
			List<GuestInfoModel> guestInfo = getGuestInfoById((String) row.get("guestInfo"));
			if (null != guestInfo && !guestInfo.isEmpty()) {
				user.setGuestInfo(guestInfo.stream().findFirst().get());
			}

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}
	
	
	public List<HgModel> getHgCheckOutById(String bookingId,String hotId) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Hg where bookingId='" + bookingId+"'");
		List<HgModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			HgModel user = new HgModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setBookingId(bookingId);
			String hotelDetails = (String) row.get("hotelDetails");

			if (null != hotelDetails) {
				for (String hotelId : hotelDetails.split(",")) {
					List<HotelModel> userModel = getHotelModelById(hotelId);
					if (null != userModel && !userModel.isEmpty()) {
						
						for(HotelModel hotel : userModel) {
							if(null!=hotel && hotel.getHotelId().equalsIgnoreCase(hotId)) {
								
								user.getHotelDetails().add(hotel);
								user.getHotelDetails().stream().findFirst().get().setWebCheckedIn(true);
								user.getHotelDetails().stream().findFirst().get().setCheckInRefId(bookingId+"_"+hotId+"_"+hotel.getUserCheckIn().getDate());
								user.getHotelDetails().stream().findFirst().get().setCheckedOut(true);
								user.getHotelDetails().stream().findFirst().get().setFeedbackEnabled(true);
								updateHotelForWebCheckOut(user.getHotelDetails().stream().findFirst().get().getId(), true, true);
							}
						}
						
					}
				}
			}
			
			List<GuestInfoModel> guestInfo = getGuestInfoById((String) row.get("guestInfo"));
			if (null != guestInfo && !guestInfo.isEmpty()) {
				user.setGuestInfo(guestInfo.stream().findFirst().get());
			}

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}
	
	
	public List<HgModel> getFeedBackDone(String bookingId,String hotId) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Hg where bookingId='" + bookingId+"'");
		List<HgModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			HgModel user = new HgModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setBookingId(bookingId);
			String hotelDetails = (String) row.get("hotelDetails");

			if (null != hotelDetails) {
				for (String hotelId : hotelDetails.split(",")) {
					List<HotelModel> userModel = getHotelModelById(hotelId);
					if (null != userModel && !userModel.isEmpty()) {
						
						for(HotelModel hotel : userModel) {
							if(null!=hotel && hotel.getHotelId().equalsIgnoreCase(hotId)) {
								
								user.getHotelDetails().add(hotel);
								user.getHotelDetails().stream().findFirst().get().setWebCheckedIn(true);
								user.getHotelDetails().stream().findFirst().get().setCheckInRefId(bookingId+"_"+hotId+"_"+hotel.getUserCheckIn().getDate());
								user.getHotelDetails().stream().findFirst().get().setCheckedOut(true);
								user.getHotelDetails().stream().findFirst().get().setFeedbackEnabled(false);
								
								updateHotelForWebCheckOut(user.getHotelDetails().stream().findFirst().get().getId(), true, false);
								
							}
						}
						
					}
				}
			}
			
			List<GuestInfoModel> guestInfo = getGuestInfoById((String) row.get("guestInfo"));
			if (null != guestInfo && !guestInfo.isEmpty()) {
				user.setGuestInfo(guestInfo.stream().findFirst().get());
			}

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}

	public void createUser(UserModel user) {
		jdbcTemplate.update((Connection connection) -> {
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO USERS (FNAME) VALUES (?)");
				preparedStatement.setString(1, user.getFname());
			} catch (Exception e) {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				throw (e);
			}
			return preparedStatement;
		});
	}
	
	
	public List<HgModel> resetBooleans(String bookingId,String hotId) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Hg where bookingId='" + bookingId+"'");
		List<HgModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			HgModel user = new HgModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setBookingId(bookingId);
			String hotelDetails = (String) row.get("hotelDetails");

			if (null != hotelDetails) {
				for (String hotelId : hotelDetails.split(",")) {
					List<HotelModel> userModel = getHotelModelById(hotelId);
					if (null != userModel && !userModel.isEmpty()) {
						
						for(HotelModel hotel : userModel) {
							if(null!=hotel && hotel.getHotelId().equalsIgnoreCase(hotId)) {
								
								user.getHotelDetails().add(hotel);
								user.getHotelDetails().stream().findFirst().get().setWebCheckedIn(false);
								user.getHotelDetails().stream().findFirst().get().setCheckInRefId(bookingId+"_"+hotId+"_"+hotel.getUserCheckIn().getDate());
								user.getHotelDetails().stream().findFirst().get().setCheckedOut(false);
								user.getHotelDetails().stream().findFirst().get().setFeedbackEnabled(false);
								
								resetBooleans(user.getHotelDetails().stream().findFirst().get().getId(), false, false, false);
								
							}
						}
						
					}
				}
			}
			
			List<GuestInfoModel> guestInfo = getGuestInfoById((String) row.get("guestInfo"));
			if (null != guestInfo && !guestInfo.isEmpty()) {
				user.setGuestInfo(guestInfo.stream().findFirst().get());
			}

			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}
	
	
	public void updateHotelForWebCheckin(String id , String checkInRefId, boolean webCheckedIn) {
		jdbcTemplate.update((Connection connection) -> {
			PreparedStatement preparedStatement = null;
			try {
				
				preparedStatement = connection.prepareStatement("UPDATE hotel SET checkInRefId = ?, webCheckedIn = ? WHERE ID = ?");
				preparedStatement.setString(1, checkInRefId);
				preparedStatement.setBoolean(2, webCheckedIn );
				preparedStatement.setString(3, id);
				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				throw (e);
			}
			return preparedStatement;
		});
	}
	
	
	public void updateHotelForWebCheckOut(String id , boolean checkedOut, boolean feedbackEnabled) {
		jdbcTemplate.update((Connection connection) -> {
			PreparedStatement preparedStatement = null;
			try {
				
				preparedStatement = connection.prepareStatement("UPDATE hotel SET checkedOut = ?, feedbackEnabled = ? WHERE ID = ?");
				preparedStatement.setBoolean(1, checkedOut);
				preparedStatement.setBoolean(2, feedbackEnabled );
				preparedStatement.setString(3, id);
				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				throw (e);
			}
			return preparedStatement;
		});
	}
		
		
		public void resetBooleans(String id , boolean checkedOut, boolean feedbackEnabled,boolean webCheckedIn) {
			jdbcTemplate.update((Connection connection) -> {
				PreparedStatement preparedStatement = null;
				try {
					
					preparedStatement = connection.prepareStatement("UPDATE hotel SET checkedOut = ?, feedbackEnabled = ?, webCheckedIn = ? WHERE ID = ?");
					preparedStatement.setBoolean(1, checkedOut);
					preparedStatement.setBoolean(2, feedbackEnabled );
					preparedStatement.setBoolean(3, webCheckedIn );
					preparedStatement.setString(4, id);
					preparedStatement.executeUpdate();
					
				} catch (Exception e) {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					throw (e);
				}
				return preparedStatement;
			});
	}

}
