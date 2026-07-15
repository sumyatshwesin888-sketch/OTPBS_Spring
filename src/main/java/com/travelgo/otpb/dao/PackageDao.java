package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.controller.PackageCity;
import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;

public interface PackageDao {

	List<ProductDto> getPackage();


	List<CityTypeDto> getPackageByLocationType(String locationType, int commentCount);


	List<CityTypeDto> getPackageByLocationType(String locationType);


	PackageCity getPackageByCity();


	List<CityTypeDto> getPackageDetail(int packageId);

}
