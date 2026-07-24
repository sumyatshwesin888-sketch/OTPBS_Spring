package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.HotelDto;

public interface HotelService {

	List<HotelDto> getHotel();

	int addHotel(HotelDto dto);

	int updateHotel(HotelDto dto);

	int deleteHotel(int hotelId);

	List<HotelDto> getHotel(String hotelName,String locationType, String search);

	


}
