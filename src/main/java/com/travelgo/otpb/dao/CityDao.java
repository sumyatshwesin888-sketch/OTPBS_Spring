package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.dto.UserAccountDto;

public interface CityDao {

	List<City> getCity();

	void saveCity(City city);

	void updateCity(City city);

	void deleteCity(City city);

	UserAccountDto login(String email, String password);

	List<City> getCity(String cityName, String search);


}
