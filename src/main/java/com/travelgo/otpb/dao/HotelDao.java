package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.domain.Hotel;
import com.travelgo.otpb.dto.HotelDto;

public interface HotelDao {

	//List<HotelDto> getHotel();

	void saveHotel(Hotel hotel);

	void updateHotel(Hotel hotel);
	

	//void deleteHotel(Hotel hotel);

	List<HotelDto> getHotel(String hotelName, String cityName, String search);

	//boolean deleteHotel(Hotel hotel);

	boolean deleteHotel(int hotelId);

}
