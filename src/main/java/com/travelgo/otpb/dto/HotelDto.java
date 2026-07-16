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
	private int hotelId; 
    private CityDto cityDto;//
    private String hotelName;//
}
