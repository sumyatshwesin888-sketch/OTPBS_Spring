package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.ItineraryDto;

public interface ItineraryService {

	List<ItineraryDto> getItinerary();

	int addItinerary(ItineraryDto dto);

	int updateItinerary(ItineraryDto dto);

	int deleteItinerary(int itineraryId);

}
