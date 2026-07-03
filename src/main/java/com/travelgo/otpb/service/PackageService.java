package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;

public interface PackageService {

	List<ProductDto> getPackage(String locationType);

	List<CityTypeDto> getPackageByLocationType(String locationType);


}
