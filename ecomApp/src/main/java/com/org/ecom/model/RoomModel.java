package com.org.ecom.model;

import java.util.List;

public class RoomModel {
	private String roomId;
	private String roomNo;
	private String floor;
	private String others;
	private String size;
	private List<String> amenity;
	private List<String> service;
	private List<String> view;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public List<String> getAmenity() {
		return amenity;
	}
	public void setAmenity(List<String> amenity) {
		this.amenity = amenity;
	}
	public List<String> getService() {
		return service;
	}
	public void setService(List<String> service) {
		this.service = service;
	}
	public List<String> getView() {
		return view;
	}
	public void setView(List<String> view) {
		this.view = view;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
