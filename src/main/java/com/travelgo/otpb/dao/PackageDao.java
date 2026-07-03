package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;

public interface PackageDao {

	List<ProductDto> getPackage(String locationType);

	List<CityTypeDto> getPackageByLocationType(String locationType);

}
