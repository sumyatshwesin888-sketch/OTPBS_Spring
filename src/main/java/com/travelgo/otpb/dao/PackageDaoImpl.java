package com.travelgo.otpb.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDto;


@Repository
public class PackageDaoImpl implements PackageDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProductDto> getPackage(String locationType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT \r\n"
				+ "tt.productId,\r\n"
				+ "tt.locationType,tt.photo,tt.title,tt.`day`,tt.night,\r\n"
				+ "tt.groupSize,tt.amount,tt.location,SUM(tt.ratingCount)\r\n"
				+ "FROM\r\n"
				+ "(SELECT p.productId,\r\n"
				+ "p.photo,p.title,p.`day`,p.night,\r\n"
				+ "p.groupSize,p.amount,p.location, 0 AS ratingCount,c.locationType\r\n"
				+ "FROM product p\r\n"
				+ " LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId  \r\n"
				+ "UNION ALL \r\n"
				+ "SELECT r.productId,\r\n"
				+ "'' AS photo,'' AS title,0 AS DAY,0 as night,\r\n"
				+ "'' as groupSize,0 as amount,'' as location,\r\n"
				+ "SUM(r.rating)/COUNT(r.ratingId) AS ratingCount,'' as locationType\r\n"
				+ "FROM rating r\r\n"
				+ ") AS tt\r\n"
				+ " GROUP BY tt.productId").getResultList();
		List<ProductDto> dtoList = new  ArrayList<ProductDto>();
		for(Object[] obj:objList) {
			int productId = Integer.parseInt(obj[0].toString());
			locationType = (String)obj[1];
			String photo = (String)obj[2];
			String title = (String)obj[3];
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			String groupSize = (String)obj[6];
			int amount = Integer.parseInt(obj[7].toString());
			String location = (String)obj[8];
			double ratingCount = Double.parseDouble(obj[9].toString());
			ProductDto dto = new ProductDto(productId,locationType,
					photo,title,day,night,groupSize,amount,location,ratingCount);
			dtoList.add(dto);
		}
		
		
		
		return dtoList;
	}

	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT \r\n"
				+ "tt.productId,tt.locationType,\r\n"
				+ "tt.photo,tt.title,tt.`day`,tt.night,\r\n"
				+ "tt.groupSize,tt.amount,tt.location,SUM(tt.ratingCount),tt.cityName,tt.cityId\r\n"
				+ "FROM \r\n"
				+ "(SELECT p.productId,\r\n"
				+ "p.photo,p.title,p.`day`,p.night,\r\n"
				+ "p.groupSize,p.amount,p.location, 0 AS ratingCount, c.locationType,c.cityName,c.cityId\r\n"
				+ "FROM product p\r\n"
				+ " LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId UNION ALL \r\n"
				+ "SELECT r.productId\r\n"
				+ ",\r\n"
				+ "'' AS photo,\"\" AS title,0 AS DAY,0 as night,\r\n"
				+ "'' as groupSize,0 as amount,'' as location,\r\n"
				+ "SUM(r.rating)/COUNT(r.ratingId) AS ratingCount,'' as locationType,'' AS cityName,'' AS cityId\r\n"
				+ "FROM rating r\r\n"
				+ ") AS tt\r\n"
				+ "  WHERE tt.productId IS NOT NULL AND tt.locationType = :locationType "
				+ "  GROUP BY tt.productId\r\n"
				+ " ORDER BY tt.cityId ASC \r\n"
				+ "").setParameter("locationType", locationType).getResultList();
		List<ProductDto> dtoList = new  ArrayList<ProductDto>();
		List<CityTypeDto> cityDtoList = new ArrayList<>();
		int tempCityId = 0;
		String tempCityName = "";
		for(Object[] obj:objList) {
			int productId = Integer.parseInt(obj[0].toString());
			locationType = (String)obj[1];
			String photo = (String)obj[2];
			String title = (String)obj[3];
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			String groupSize = (String)obj[6];
			int amount = Integer.parseInt(obj[7].toString());
			String location = (String)obj[8];
			double ratingCount = Double.parseDouble(obj[9].toString());
			String cityName = (String)obj[10];
			int cityId = Integer.parseInt(obj[11].toString());
			
			if(tempCityId==0) {//1
				tempCityId = cityId;
				tempCityName = cityName;
			}else if(tempCityId==cityId) {//2
				
			}else{//3
				CityTypeDto type = new CityTypeDto();
				type.setCityName(tempCityName);
				type.setProductList(dtoList);
				tempCityId = cityId;
				tempCityName = cityName;
				dtoList = new ArrayList<>();
				cityDtoList.add(type);
				
			}
			ProductDto dto = new ProductDto(productId,locationType,
					photo,title,day,night,groupSize,amount,location,ratingCount);
			dtoList.add(dto);//1,2//1
			
		}
		
		if(dtoList.size()>0){//
			CityTypeDto type = new CityTypeDto();
			type.setCityName(tempCityName);
			type.setProductList(dtoList);
			cityDtoList.add(type);
		}
		
		return cityDtoList;
	}

}
