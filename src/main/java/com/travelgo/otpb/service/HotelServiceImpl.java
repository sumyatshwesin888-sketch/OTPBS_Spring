package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.HotelDao;
import com.travelgo.otpb.domain.Hotel;
import com.travelgo.otpb.dto.HotelDto;


@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelDao hotelDao;

	@Transactional(readOnly=true)
	@Override
	public List<HotelDto> getHotel() {
		// TODO Auto-generated method stub
		return hotelDao.getHotel();
		}
	
	@Transactional(readOnly=false)
	@Override
	public int addHotel(HotelDto dto) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel(dto);
		hotelDao.saveHotel(hotel);
		return hotel.getHotelId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateHotel(HotelDto dto) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel(dto);
		hotelDao.updateHotel(hotel);
		return hotel.getHotelId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteHotel(int hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel();
		hotel.setHotelId(hotelId);
		hotelDao.deleteHotel(hotel);
		return hotelId;
	}

	

	
	
}
