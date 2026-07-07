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
	public List<ProductDto> getPackage() {
		// TODO Auto-generated method stub
		
		return packDao.getPackage();
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType) {
		// TODO Auto-generated method stub
		return packDao.getPackageByLocationType(locationType);
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityTypeDto> getPackageDetail(int packageId) {
		// TODO Auto-generated method stub
		return packDao.getPackageDetail(packageId);
	}

	@Transactional(readOnly=false)
	@Override
	public int addPackage(ProductDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(readOnly=false)
	@Override
	public int updatePackage(ProductDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(readOnly=false)
	@Override
	public int deletePackage(int packageId) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
