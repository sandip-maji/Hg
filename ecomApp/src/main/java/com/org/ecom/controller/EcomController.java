package com.org.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.ecom.dao.CommonDAOService;
import com.org.ecom.model.HgModel;
import com.org.ecom.model.RoomModel;
import com.org.ecom.model.UserModel;
import com.org.ecom.util.CommonUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = { "*" }, maxAge = 6000, allowCredentials = "false")
@RestController
public class EcomController {

	@Autowired
	CommonUtil commonUtil;

	@Autowired
	CommonDAOService pivotalDAOService;

	@GetMapping(value = "/appInfo")
	public String getAppInfo() {
		return "EcomApplication";
	}

	@ApiOperation(value = "bookingInfo", nickname = "bookingInfo")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = HgModel.class, responseContainer = "List") })

	@GetMapping(value = "/bookingInfo")
	public ResponseEntity<HgModel> getBookingInfo(
			@ApiParam(value = "bookedId", required = true) @RequestParam("bookedId") String bookedId) {

		// HgModel hgModel = commonUtil.getMockHgModelByBookingId(bookedId);
		List<HgModel> hgModels = pivotalDAOService.getHgById(bookedId);

		HgModel hgModel = null;
		if (null != hgModels && !hgModels.isEmpty()) {
			hgModel = hgModels.stream().findFirst().get();
		}

		return new ResponseEntity<HgModel>(hgModel, HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "webCheckedIn", nickname = "webCheckedIn")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = HgModel.class, responseContainer = "List") })

	@GetMapping(value = "/webCheckedIn")
	public ResponseEntity<HgModel> getWebCheckedIn(
			@ApiParam(value = "bookedId", required = true) @RequestParam("bookedId") String bookedId,			
			@ApiParam(value = "hotelId", required = true) @RequestParam("hotelId") String hotelId) {

		// HgModel hgModel = commonUtil.getMockHgModelByBookingId(bookedId);
		List<HgModel> hgModels = pivotalDAOService.getHgCheckInById(bookedId,hotelId);

		HgModel hgModel = null;
		if (null != hgModels && !hgModels.isEmpty()) {
			hgModel = hgModels.stream().findFirst().get();
		}

		return new ResponseEntity<HgModel>(hgModel, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/webCheckedOut")
	public ResponseEntity<HgModel> getWebCheckedOut(
			@ApiParam(value = "bookedId", required = true) @RequestParam("bookedId") String bookedId,			
			@ApiParam(value = "hotelId", required = true) @RequestParam("hotelId") String hotelId) {

		// HgModel hgModel = commonUtil.getMockHgModelByBookingId(bookedId);
		List<HgModel> hgModels = pivotalDAOService.getHgCheckOutById(bookedId,hotelId);

		HgModel hgModel = null;
		if (null != hgModels && !hgModels.isEmpty()) {
			hgModel = hgModels.stream().findFirst().get();
		}

		return new ResponseEntity<HgModel>(hgModel, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value = "/feedBackDone")
	public ResponseEntity<HgModel> getFeedBackDone(
			@ApiParam(value = "bookedId", required = true) @RequestParam("bookedId") String bookedId,			
			@ApiParam(value = "hotelId", required = true) @RequestParam("hotelId") String hotelId) {

		// HgModel hgModel = commonUtil.getMockHgModelByBookingId(bookedId);
		List<HgModel> hgModels = pivotalDAOService.getHgCheckOutById(bookedId,hotelId);

		HgModel hgModel = null;
		if (null != hgModels && !hgModels.isEmpty()) {
			hgModel = hgModels.stream().findFirst().get();
		}

		return new ResponseEntity<HgModel>(hgModel, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value = "/resetBooleans")
	public ResponseEntity<HgModel> resetBooleans(
			@ApiParam(value = "bookedId", required = true) @RequestParam("bookedId") String bookedId,			
			@ApiParam(value = "hotelId", required = true) @RequestParam("hotelId") String hotelId) {

		// HgModel hgModel = commonUtil.getMockHgModelByBookingId(bookedId);
		List<HgModel> hgModels = pivotalDAOService.resetBooleans(bookedId,hotelId);

		HgModel hgModel = null;
		if (null != hgModels && !hgModels.isEmpty()) {
			hgModel = hgModels.stream().findFirst().get();
		}

		return new ResponseEntity<HgModel>(hgModel, HttpStatus.ACCEPTED);
	}

	/*@ApiOperation(value = "roomDetails", nickname = "roomDetails")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = RoomModel.class, responseContainer = "List") })

	@GetMapping(value = "/roomDetails")
	public ResponseEntity<RoomModel> getRoomDetails(
			@ApiParam(value = "bookedId", required = true, defaultValue = "1234") @RequestParam("bookedId") String bookedId,
			@ApiParam(value = "hotelId", required = true, defaultValue = "1234") @RequestParam("hotelId") String hotelId) {

		RoomModel roomModel = commonUtil.getRoomDetails(hotelId, bookedId);

		return new ResponseEntity<RoomModel>(roomModel, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "validateId", nickname = "validateId")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = HgModel.class, responseContainer = "List") })

	@PostMapping(value = "/validateId")
	public ResponseEntity<HgModel> getVerifyInfo(
			@ApiParam(value = "bookedId", required = true, defaultValue = "1234") @RequestParam("bookedId") String bookedId) {

		HgModel hgModel = commonUtil.getValidateId(bookedId);

		return new ResponseEntity<HgModel>(hgModel, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/users")
	public List<UserModel> getUsers() {
		return pivotalDAOService.getUsers();
	}

	@PostMapping(value = "/users")
	public String createUser(@RequestBody UserModel user) {
		pivotalDAOService.createUser(user);
		return "User created successfully";
	}*/

}
