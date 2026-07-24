package com.travelgo.otpb.dto;


import com.travelgo.otpb.domain.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class HotelDto {
   
	public HotelDto(int hotelId, String hotelName) {
		// TODO Auto-generated constructor stub
		this.hotelId = hotelId;
    	this.hotelName = hotelName;
	}
	
//	public HotelDto(HotelDto hotel2) {
//		// TODO Auto-generated constructor stub
//		this.hotel=hotel2;
//	}
	private int hotelId; 
    private CityDto cityDto;
    private String hotelName;

//	private HotelDto hotel;
//
//	public void setHotelId(int hotelId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public HotelDto(String htName) {
//		// TODO Auto-generated constructor stub
//		this.hotelName=htName;
//	}
//
//	public void setCityName(String cityName1) {
//		// TODO Auto-generated method stub
//		
//	}
}
