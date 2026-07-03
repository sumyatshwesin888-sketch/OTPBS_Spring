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
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.HotelDto;
import com.travelgo.otpb.dto.ItineraryDto;
import com.travelgo.otpb.service.ItineraryService;

@RestController
@RequestMapping("/api/v1/")
public class ItineraryController {
	@Autowired
	ItineraryService iService;
	
	@GetMapping("itinerary")
	public List<ItineraryDto> getItinerary() {
		
		return iService.getItinerary();
	}
	
	@PostMapping("itinerary")
	public int addItinerary(@RequestBody ItineraryDto dto) {
		
		return iService.addItinerary(dto);
	}
	
	@PutMapping("itinerary/{itineraryId}")
	public int updateItinerary(
			@PathVariable("itineraryId")int itineraryId,
			@RequestBody ItineraryDto dto) {
		dto.setItineraryId(itineraryId);
		return iService.updateItinerary(dto);
	}
	
	
	@DeleteMapping("itinerary/{itineraryId}")
	public int deleteItinerary(
			@PathVariable("itineraryId")int itineraryId) {
		return iService.deleteItinerary(itineraryId);
	}
}
