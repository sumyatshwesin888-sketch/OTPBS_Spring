package com.travelgo.otpb.dto;

import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.dto.CityDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class CityDto {

	public CityDto(City city) {
		// TODO Auto-generated constructor stub
		this.cityId = city.getCityId();
		this.cityName = city.getCityName();
		this.locationType =city.getLocationType();
		this.photo = city.getPhoto();
		this.region = city.getRegion();
		this.website = city.getWebsite();
		this.detail = city.getDetail();
	}

	public CityDto(int cityId, String cityName) {
		// TODO Auto-generated constructor stub
		this.cityId = cityId;
		this.cityName = cityName;
	}

	private int cityId;
	private String cityName;
	private String locationType;
	private String photo;
	private String region;
	private String website;
	private String detail;


	}
