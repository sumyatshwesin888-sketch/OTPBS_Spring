package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.CityDao;
import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.UserAccountDto;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityDao cityDao;

	@Transactional(readOnly=true)
	@Override
	public List<CityDto> getCity() {
		// TODO Auto-generated method stub
		List<City> cityList = cityDao.getCity();
		List<CityDto> dtoList = new ArrayList<CityDto>();
		for(City city:cityList) {
			CityDto dto = new CityDto(city);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Transactional(readOnly=false)
	@Override
	public int addCity(CityDto dto) {
		// TODO Auto-generated method stub
		City city = new City(dto);
		cityDao.saveCity(city);
		return city.getCityId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateCity(CityDto dto) {
		// TODO Auto-generated method stub
		City city = new City(dto);
		cityDao.updateCity(city);
		return city.getCityId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteCity(int cityId) {
		// TODO Auto-generated method stub
		City city = new City();
		city.setCityId(cityId);
		cityDao.deleteCity(city);
		return cityId;
	}
	@Transactional(readOnly=true)
	@Override
	public UserAccountDto login(String email, String password) {
		// TODO Auto-generated method stub
		return cityDao.login(email,password);
	}

	
	
}
