package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.PackageDao;
import com.travelgo.otpb.dao.ProductDao;
import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;


@Service
public class PackageServiceImpl implements PackageService {
	@Autowired
	PackageDao packDao;

	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getPackage(String locationType) {
		// TODO Auto-generated method stub
		
		return packDao.getPackage(locationType);
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType) {
		// TODO Auto-generated method stub
		return packDao.getPackageByLocationType(locationType);
	}


}
