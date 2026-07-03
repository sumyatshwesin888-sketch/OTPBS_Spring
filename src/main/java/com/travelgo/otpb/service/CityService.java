package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.UserAccountDto;

public interface CityService {

	List<CityDto> getCity();

	int addCity(CityDto dto);

	int updateCity(CityDto dto);

	int deleteCity(int cityId);

	UserAccountDto login(String email, String password);


}
