package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.controller.PackageCity;
import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.RatingDto;

public interface PackageService {

	List<ProductDto> getPackage();

	List<CityTypeDto> getPackageByLocationType(String locationType);

	List<CityTypeDto> getPackageDetail(int packageId);

	int addPackage(ProductDto dto);

	int updatePackage(ProductDto dto);

	int deletePackage(int packageId);

	PackageCity getPackageByCity();

	int saveRatingComment(RatingDto dto);

	List<CityTypeDto> getPackageByLocationTypeCommCount(String locationType, int commentCount);
	


}
