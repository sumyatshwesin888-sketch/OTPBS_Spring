package com.travelgo.otpb.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.HotelDto;
import com.travelgo.otpb.dto.ItineraryDto;
import com.travelgo.otpb.dto.ProductDto;


@Repository
public class PackageDaoImpl implements PackageDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProductDto> getPackage() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
//		List<Object[]> objList = session.createNativeQuery("SELECT \r\n"
//				+ "tt.productId,\r\n"
//				+ "tt.locationType,tt.photo,tt.title,tt.`day`,tt.night,\r\n"
//				+ "tt.groupSize,tt.amount,tt.location,SUM(tt.ratingCount)\r\n"
//				+ "FROM\r\n"
//				+ "(SELECT p.productId,\r\n"
//				+ "p.photo,p.title,p.`day`,p.night,\r\n"
//				+ "p.groupSize,p.amount,p.location, 0 AS ratingCount,c.locationType\r\n"
//				+ "FROM product p\r\n"
//				+ " LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
//				+ "LEFT JOIN city c ON c.cityId = h.cityId  \r\n"
//				+ "UNION ALL \r\n"    
//				+ "SELECT r.productId,\r\n"
//				+ "'' AS photo,'' AS title,0 AS DAY,0 as night,\r\n"
//				+ "'' as groupSize,0 as amount,'' as location,\r\n"
//				+ "SUM(r.rating)/COUNT(r.ratingId) AS ratingCount,'' as locationType\r\n"
//				+ "FROM rating r\r\n"
//				+ ") AS tt\r\n"
//				+ " GROUP BY tt.productId").getResultList();
		
		
		String  sql = "";
		
		//if("ALL".equals(locationType)) {
			sql = "SELECT p.productId, c.locationType, p.photo, p.title,\r\n"
					+ "p.`day`, p.night, p.groupSize, p.amount,\r\n"
					+ "p.location,IFNULL(AVG(r.rating),0) AS ratingCount, COUNT( DISTINCT  cm.commentId) AS commmentCount\r\n"
					+ "FROM product p\r\n"
					+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
					+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
					+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
					+" LEFT JOIN comment cm ON cm.productId = p.productId "
					+ "WHERE 1=1 \r\n"
					+ "GROUP BY p.productId\r\n"
					+ "ORDER BY p.productId";

//		}else {
//			sql = "SELECT p.productId, c.locationType, p.photo, p.title,\r\n"
//					+ "p.`day`, p.night, p.groupSize, p.amount,\r\n"
//					+ "p.location,IFNULL(AVG(r.rating),0) AS ratingCount\r\n"
//					+ "c.message\r\n"
//					+ "FROM product p\r\n"
//					+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
//					+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
//					+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
//					+"LEFT JOIN comment c ON c.productId = p.productId\r\n"
//					+ "WHERE 1=1 \r\n"
//					+ "AND c.locationType = '" + locationType+"'\r\n"
//					+ "GROUP BY p.productId\r\n"
//					+ "ORDER BY p.productId";
//		}

//		}else {
//			sql = "SELECT p.productId, c.locationType, p.photo, p.title,\r\n"
//					+ "p.`day`, p.night, p.groupSize, p.amount,\r\n"
//					+ "p.location,IFNULL(AVG(r.rating),0) AS ratingCount, COUNT(cm.commentId) AS commentCount\r\n"
//					+ "FROM product p\r\n"
//					+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
//					+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
//					+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
//					+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
//					+ "WHERE 1=1 \r\n"
//					+ "GROUP BY p.productId\r\n"
//					+ "ORDER BY p.productId";
//		}

		
		List<Object[]> objList = session.createNativeQuery(sql).getResultList();
		List<ProductDto> dtoList = new  ArrayList<ProductDto>();
		for(Object[] obj:objList) {
			int productId = Integer.parseInt(obj[0].toString());
			String locationType = (String)obj[1];
			String photo = (String)obj[2];
			String title = (String)obj[3];
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			String groupSize = (String)obj[6];
			int amount = Integer.parseInt(obj[7].toString());
			String location = (String)obj[8];
			double ratingCount = Double.parseDouble(obj[9].toString());
			int commentCount = Integer.parseInt(obj[10].toString());
			ProductDto dto = new ProductDto(productId,locationType,
					photo,title,day,night,groupSize,amount,location,ratingCount,commentCount);
			dtoList.add(dto);
		}
		
		
		
		return dtoList;
	}

	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType, int commentCount) {
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
					photo,title,day,night,groupSize,amount,location,ratingCount,commentCount);
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

	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
//		List<Object[]> objList = session.createNativeQuery("SELECT \r\n"
//				+ "tt.productId,tt.locationType,\r\n"
//				+ "tt.photo,tt.title,tt.`day`,tt.night,\r\n"
//				+ "tt.groupSize,tt.amount,tt.location,SUM(tt.ratingCount),tt.cityName,tt.cityId\r\n"
//				+ "FROM \r\n"
//				+ "(SELECT p.productId,\r\n"
//				+ "p.photo,p.title,p.`day`,p.night,\r\n"
//				+ "p.groupSize,p.amount,p.location, 0 AS ratingCount, c.locationType,c.cityName,c.cityId\r\n"
//				+ "FROM product p\r\n"
//				+ " LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
//				+ "LEFT JOIN city c ON c.cityId = h.cityId UNION ALL \r\n"
//				+ "SELECT r.productId\r\n"
//				+ ",\r\n"
//				+ "'' AS photo,\"\" AS title,0 AS DAY,0 as night,\r\n"
//				+ "'' as groupSize,0 as amount,'' as location,\r\n"
//				+ "SUM(r.rating)/COUNT(r.ratingId) AS ratingCount,'' as locationType,'' AS cityName,'' AS cityId\r\n"
//				+ "FROM rating r\r\n"
//				+ ") AS tt\r\n"
//				+ "  WHERE tt.productId IS NOT NULL AND tt.locationType = :locationType "
//				+ "  GROUP BY tt.productId\r\n"
//				+ " ORDER BY tt.cityId ASC \r\n"
//				+ "").setParameter("locationType", locationType).getResultList();
		String sql = "SELECT p.productId, c.locationType, p.photo, p.title,\r\n"
				+ "p.`day`, p.night, p.groupSize, p.amount,\r\n"
				+ "p.location,IFNULL(AVG(r.rating),0) AS ratingCount"
				+ " ,c.cityName,c.cityId "
				+ ", COUNT( DISTINCT  cm.commentId) AS commmentCount\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
				+" LEFT JOIN comment cm ON cm.productId = p.productId "
				+ "WHERE c.locationType =:locationType \r\n"
				+ "GROUP BY p.productId\r\n"
				+ "ORDER BY p.productId";
		List<Object[]> objList = session.createNativeQuery(sql)
				.setParameter("locationType", locationType).getResultList();
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
			int commentCount = Integer.parseInt(obj[12].toString());
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
					photo,title,day,night,groupSize,amount,location,ratingCount,commentCount);
			
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

	@Override
	public List<CityTypeDto> getPackageDetail(int packageId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT p.productId,p.title, p.location, p.amount, p.`day`, p.night, p.travelDate, p.ticket, p.groupSize, p.meals,\r\n"
				+ " AVG(r.rating) AS ragingCount, (cm.commentId) AS commentCount, p.photoone, p.photoTwo, p.photoThree, p.photoFour,\r\n"
				+ " h.hotelId, h.hotelName, p.detail, it.dayNo,  it.title AS itTitle, it.detail AS itDetail, p.transport, COUNT(s.saleId ) AS saleCount\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
				+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN itinerary it ON it.productId = p.productId\r\n"
				+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
				+ "WHERE p.productId = :packageId\r\n"
				+ "GROUP BY p.productId\r\n"
				+ "").setParameter("packageId", packageId).getResultList();
		List<ProductDto> dtoList = new  ArrayList<ProductDto>();
		List<CityTypeDto> cityDtoList = new ArrayList<>();
		int tempCityId = 0;
		String tempCityName = "";
		for(Object[] obj:objList) {
			int productId = Integer.parseInt(obj[0].toString());
			String title = (String)obj[1];
			String location = (String)obj[2];
			int amount = Integer.parseInt(obj[3].toString());
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			Date travelDate = (Date) obj[6];
			int ticket = Integer.parseInt(obj[7].toString());
			String groupSize = (String)obj[8];
			String meals = (String)obj[9];
			double ratingCount = Double.parseDouble(obj[10].toString());
			int commentCount = Integer.parseInt(obj[11].toString());
			String photoOne = (String)obj[12];
			String photoTwo = (String)obj[13];
			String photoThree = (String)obj[14];
			String photoFour = (String)obj[15];
			int hotelId = Integer.parseInt(obj[16].toString());
			String hotelName = (String)obj[17];
			
			String detail = (String)obj[18];
			int dayNo = Integer.parseInt(obj[19].toString());
			String itineraryTitle = (String)obj[20];
			String itineraryDetail = (String)obj[21];
			String transport = (String)obj[22];
			int saleCount = Integer.parseInt(obj[23].toString());
			int leftTicket = ticket - saleCount;
			
			
		
			ProductDto dto = new ProductDto(productId,title,location,amount,day,night,travelDate,
					ticket,groupSize,meals,ratingCount,commentCount,photoOne,photoTwo,
					photoThree,photoFour,detail,transport);
			dto.setHotelDto(new HotelDto(hotelId,hotelName));
			dto.setItineraryDto(new ItineraryDto(dayNo,itineraryTitle,itineraryDetail));
			dto.setLeftTicket(leftTicket);
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
