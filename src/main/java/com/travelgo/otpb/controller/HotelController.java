package com.travelgo.otpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.HotelDto;
import com.travelgo.otpb.service.CityService;
import com.travelgo.otpb.service.HotelService;
@RestController
@RequestMapping("/api/v1/")
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@GetMapping("hotel")
	public List<HotelDto> getHotel(@RequestParam(name="hotelName",defaultValue = "ALL")String hotelName,
			@RequestParam(name="cityName",defaultValue = "ALL")String cityName,
    		@RequestParam(name="search",defaultValue = "")String search) {
	
		return hotelService.getHotel(hotelName,cityName, search);
	}
	
//	@GetMapping("hotel")
//	public List<HotelDto> getHotel() {
//		
//		return hotelService.getHotel();
//	}
	
	@PostMapping("hotel")
	public int addHotel(@RequestBody HotelDto dto) {
		
		return hotelService.addHotel(dto);
	}
	@PutMapping("hotel/{hotelId}")
	public int updateHotel(
			@PathVariable("hotelId")int hotelId,
			@RequestBody HotelDto dto) {
		dto.setHotelId(hotelId);
		return hotelService.updateHotel(dto);
	}
	@DeleteMapping("hotel/{hotelId}")
	public int deleteHotel(
			@PathVariable("hotelId")int hotelId) {
		return hotelService.deleteHotel(hotelId);
	}
}
