package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.ItineraryDao;
import com.travelgo.otpb.domain.Hotel;
import com.travelgo.otpb.domain.Itinerary;
import com.travelgo.otpb.dto.ItineraryDto;

@Service
public class ItineraryServiceImpl implements ItineraryService{
	@Autowired
	ItineraryDao iDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<ItineraryDto> getItinerary() {
		// TODO Auto-generated method stub
		return iDao.getItineray();
	}

	@Transactional(readOnly=false)
	@Override
	public int addItinerary(ItineraryDto dto) {
		// TODO Auto-generated method stub
		Itinerary i = new Itinerary(dto);
		iDao.addItinerary(i);
		return i.getItineraryId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateItinerary(ItineraryDto dto) {
		// TODO Auto-generated method stub
		Itinerary i = new Itinerary(dto);
		iDao.updateItinerary(i);
		return i.getItineraryId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteItinerary(int itineraryId) {
		// TODO Auto-generated method stub
		Itinerary i = new Itinerary();
		i.setItineraryId(itineraryId);
		iDao.deleteItinerary(i);
		return itineraryId;
	}
	
}
