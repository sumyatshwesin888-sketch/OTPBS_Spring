package com.travelgo.otpb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.UserAccountDto;
import com.travelgo.otpb.service.CityService;
@RestController
@RequestMapping("/api/v1/")
public class CityController {
	@Autowired
	CityService cityService;
	
	@GetMapping("city")
	public List<CityDto> getCity(@RequestParam(name="cityName",defaultValue = "ALL")String cityName,
    		@RequestParam(name="search",defaultValue = "")String search) {
	
		return cityService.getCity(cityName,search);
	}
	
//	@GetMapping("city")
//	public List<CityDto> getCity() {
//		
//		return cityService.getCity();
//	}
	
	@PostMapping("city")
	public int addCity(@RequestBody CityDto dto) {
		
		return cityService.addCity(dto);
	}
	@PutMapping("city/{cityId}")
	public int updateCity(
			@PathVariable("cityId")int cityId,
			@RequestBody CityDto dto) {
		dto.setCityId(cityId);
		return cityService.updateCity(dto);
	}
	@DeleteMapping("city/{cityId}")
	public int deleteCity(
			@PathVariable("cityId")int cityId) {
		return cityService.deleteCity(cityId);
	}
	
//	@GetMapping("user/login")
//	public UserAccountDto login(@RequestParam("email")String email,@RequestParam("password")String password) {
//
//		try {
//				
//				return cityService.login(email.toLowerCase().toString(),password.toLowerCase().toString());
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("UserName and Password is wrong!", e);
//		}
//	}
}
