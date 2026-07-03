package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Itinerary;
import com.travelgo.otpb.dto.ItineraryDto;

public interface ItineraryDao {

	List<ItineraryDto> getItineray();

	void addItinerary(Itinerary i);

	void updateItinerary(Itinerary i);

	void deleteItinerary(Itinerary i);

	

}
