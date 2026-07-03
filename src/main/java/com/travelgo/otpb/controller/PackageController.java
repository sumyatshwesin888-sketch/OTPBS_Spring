package com.travelgo.otpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.service.PackageService;
import com.travelgo.otpb.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class PackageController {
	@Autowired
	PackageService packService;
	
	@GetMapping("package")
	public List<ProductDto> getPackage(@RequestParam(name="locationType",defaultValue = "ALL")String locationType) {//locationType is 
		try {
			return packService.getPackage(locationType);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("package/type")
	public List<CityTypeDto> getPackageByLocationType(@RequestParam(name="locationType",defaultValue = "DOMESTIC")String locationType) {//locationType is 
		try {
			return packService.getPackageByLocationType(locationType);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
