package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;

public interface PackageService {

	List<ProductDto> getPackage();

	List<CityTypeDto> getPackageByLocationType(String locationType);

	List<CityTypeDto> getPackageDetail(int packageId);

	int addPackage(ProductDto dto);

	int updatePackage(ProductDto dto);

	int deletePackage(int packageId);
	


}
