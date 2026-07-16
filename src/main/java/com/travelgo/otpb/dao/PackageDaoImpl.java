package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.controller.PackageCity;
import com.travelgo.otpb.dto.CityDto;
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
		
	
		String  sql = "";
		//For ALL Package page
		//if("ALL".equals(locationType)) {
			sql = "SELECT p.productId, c.locationType, p.photo, p.title,\r\n"
					+ "p.`day`, p.night, p.groupSize, p.amount,\r\n"
					+ "p.location,IFNULL(AVG(r.rating),0) AS ratingCount, COUNT( DISTINCT  cm.commentId) AS commmentCount, p.type,\r\n"
					+ "p.ticket, COUNT(DISTINCT s.saleId) AS saleCount\r\n"
					+ "FROM product p\r\n"
					+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
					+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
					+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
					+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
					+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
					+ "WHERE 1=1\r\n"
					+ "GROUP BY p.productId\r\n"
					+ "ORDER BY p.productId";
			
			

		List<Object[]> objList = session.createNativeQuery(sql).getResultList();
		List<ProductDto> dtoList = new  ArrayList<ProductDto>();
		for(Object[] obj:objList) {
			int productId = Integer.parseInt(obj[0].toString());
			System.out.println(productId);
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
			String type = (String)obj[11];
			int ticket = Integer.parseInt(obj[12].toString());
			int saleCount = Integer.parseInt(obj[13].toString());
			int leftTicket = ticket - saleCount;
			
			ProductDto dto = new ProductDto(productId,locationType,
					photo,title,day,night,groupSize,amount,location,ratingCount,commentCount,type,ticket,saleCount,leftTicket);
			dto.setProductId(productId);
			dto.setType(type);
			dtoList.add(dto);
		}
		
		
		
		return dtoList;
	}

	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType, int commentCount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery( "SELECT \r\n"
				+ "tt.productId,tt.locationType,\r\n"
				+ "tt.photo,tt.title,tt.`day`,tt.night,\r\n"
				+ "tt.groupSize,tt.amount,tt.location,SUM(tt.ratingCount),tt.cityName,tt.cityId,tt.type\r\n"
				+ "FROM \r\n"
				+ "(SELECT p.productId,\r\n"
				+ "p.photo,p.title,p.`day`,p.night,\r\n"
				+ "p.groupSize,p.amount,p.location, 0 AS ratingCount, c.locationType,c.cityName,c.cityId, p.`type`\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId UNION ALL \r\n"
				+ "SELECT r.productId,\r\n"
				+ "'' AS photo,'' AS title,0 AS DAY,0 as night,\r\n"
				+ "'' as groupSize,0 as amount,'' as location,\r\n"
				+ "SUM(r.rating)/COUNT(r.ratingId) AS ratingCount,'' as locationType,'' AS cityName,'' AS cityId, ''AS type \r\n"
				+ "FROM rating r\r\n"
				+ ") AS tt\r\n"
				+ "WHERE tt.productId IS NOT NULL AND tt.locationType = locationType \r\n"
				+ "GROUP BY tt.productId\r\n"
				+ "ORDER BY tt.cityId ASC").setParameter("locationType", locationType).getResultList();
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
			String type = (String)obj[12];
			
			if(tempCityId==0) {//1
				tempCityId = cityId;
				tempCityName = cityName;
			}else if(tempCityId==cityId) {//2
				
			}else{//3
				CityTypeDto ctype = new CityTypeDto();
				ctype.setCityName(tempCityName);
				ctype.setProductList(dtoList);
				tempCityId = cityId;
				tempCityName = cityName;
				dtoList = new ArrayList<>();
				cityDtoList.add(ctype);
				
			}
			
			ProductDto dto = new ProductDto(productId,locationType,
					photo,title,day,night,groupSize,amount,location,ratingCount,commentCount);
			dtoList.add(dto);//1,2//1
			
		}
		
		if(dtoList.size()>0){//
			CityTypeDto ctype = new CityTypeDto();
			ctype.setCityName(tempCityName);
			ctype.setProductList(dtoList);
			cityDtoList.add(ctype);
		}
		
		return cityDtoList;
	}

	//For Domestic and Internation Package Page
	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT p.productId, c.locationType, p.photo, p.title,\r\n"
				+ "p.`day`, p.night, p.groupSize, p.amount,\r\n"
				+ "p.location,IFNULL(AVG(r.rating),0) AS ratingCount\r\n"
				+ " ,c.cityName,c.cityId\r\n"
				+ ", COUNT( DISTINCT  cm.commentId) AS commmentCount, p.type,\r\n"
				+ "p.ticket, COUNT(DISTINCT s.saleId) AS saleCount\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
				+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
				+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
				+ "WHERE c.locationType =locationType \r\n"
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
			String type = (String)obj[13];
			int ticket = Integer.parseInt(obj[14].toString());
			int saleCount = Integer.parseInt(obj[15].toString());
			int leftTicket =  ticket - saleCount;
			
			
			if(tempCityId==0) {//1
				tempCityId = cityId;
				tempCityName = cityName;
			}else if(tempCityId==cityId) {//2
				
			}else{//3
				CityTypeDto ctype = new CityTypeDto();
				ctype.setCityName(tempCityName);
				ctype.setProductList(dtoList);
				tempCityId = cityId;
				tempCityName = cityName;
				dtoList = new ArrayList<>();
				cityDtoList.add(ctype);
				
			}
			
			ProductDto dto = new ProductDto(productId,locationType,
					photo,title,day,night,groupSize,amount,location,ratingCount,commentCount, ticket,saleCount, leftTicket);
//			System.out.println(photo);
			dtoList.add(dto);//1,2//1
			
		}
		
		if(dtoList.size()>0){//
			CityTypeDto ctype = new CityTypeDto();
			ctype.setCityName(tempCityName);
			ctype.setProductList(dtoList);
			cityDtoList.add(ctype);
		}
		
		return cityDtoList;
	}

	//for Package Detail
	@Override
	public List<CityTypeDto> getPackageDetail(int packageId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT p.productId,p.title, p.location, p.amount, p.`day`, p.night, p.travelDate, p.ticket, p.groupSize, p.meals,\r\n"
				+ " AVG(r.rating) AS ratingCount, (cm.commentId) AS commentCount, p.photoone, p.photoTwo, p.photoThree, p.photoFour,\r\n"
				+ " h.hotelId, h.hotelName, p.detail, it.dayNo,  it.title AS itTitle, it.detail AS itDetail, p.transport, COUNT(s.saleId ) AS saleCount\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
				+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN itinerary it ON it.productId = p.productId\r\n"
				+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
				+ "WHERE p.productId = :packageId\r\n"
				+ "GROUP BY p.productId,it.itineraryId\r\n"
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

//	@Override
//	public List<CityTypeDto> getPackageDetail(int packageId) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		List<Object[]> objList = session.createNativeQuery("SELECT p.productId,p.title, p.location, p.amount, p.`day`, p.night, p.travelDate, p.ticket, p.groupSize, p.meals,\r\n"
//				+ " AVG(r.rating) AS ratingCount, (cm.commentId) AS commentCount, p.photoone, p.photoTwo, p.photoThree, p.photoFour,\r\n"
//				+ " h.hotelId, h.hotelName, p.detail, it.dayNo,  it.title AS itTitle, it.detail AS itDetail, p.transport, COUNT(s.saleId ) AS saleCount\r\n"
//				+ "FROM product p\r\n"
//				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
//				+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
//				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
//				+ "LEFT JOIN itinerary it ON it.productId = p.productId\r\n"
//				+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
//				+ "WHERE p.productId = :packageId\r\n"
//				+ "GROUP BY p.productId,it.itineraryId\r\n"
//				+ "").setParameter("packageId", packageId).getResultList();
//		List<ProductDto> dtoList = new  ArrayList<ProductDto>();
//		List<CityTypeDto> cityDtoList = new ArrayList<>();
//		int tempCityId = 0;
//		String tempCityName = "";
//		for(Object[] obj:objList) {
//			int productId = Integer.parseInt(obj[0].toString());
//			String title = (String)obj[1];
//			String location = (String)obj[2];
//			int amount = Integer.parseInt(obj[3].toString());
//			int day = Integer.parseInt(obj[4].toString());
//			int night = Integer.parseInt(obj[5].toString());
//			Date travelDate = (Date) obj[6];
//			int ticket = Integer.parseInt(obj[7].toString());
//			
//			String groupSize = (String)obj[8];
//			
//			String meals = (String)obj[9];
//		
//			double ratingCount = Double.parseDouble(obj[10].toString());
//			int commentCount = Integer.parseInt(obj[11].toString());
//			String photoOne = (String)obj[12];
//			String photoTwo = (String)obj[13];
//			String photoThree = (String)obj[14];
//			String photoFour = (String)obj[15];
//			int hotelId = Integer.parseInt(obj[16].toString());
//			String hotelName = (String)obj[17];
//			
//			String detail = (String)obj[18];
//			int dayNo = Integer.parseInt(obj[19].toString());
//			String itineraryTitle = (String)obj[20];
//			String itineraryDetail = (String)obj[21];
//			String transport = (String)obj[22];
//			int saleCount = Integer.parseInt(obj[23].toString());
//			int leftTicket = ticket - saleCount;
//			
//			
//		
//			ProductDto dto = new ProductDto(productId,title,location,amount,day,night,travelDate,
//					ticket,groupSize,meals,ratingCount,commentCount,photoOne,photoTwo,
//					photoThree,photoFour,detail,transport);
//			dto.setHotelDto(new HotelDto(hotelId,hotelName));
//			dto.setItineraryDto(new ItineraryDto(dayNo,itineraryTitle,itineraryDetail));
//			dto.setLeftTicket(leftTicket);
//			dtoList.add(dto);//1,2//1
//			
//		}
//		
//		if(dtoList.size()>0){//
//			CityTypeDto type = new CityTypeDto();
//			type.setCityName(tempCityName);
//			type.setProductList(dtoList);
//			cityDtoList.add(type);
//		}
//		
//		return cityDtoList;
//	}


//for Destination Page
	@Override
	public PackageCity getPackageByCity() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT  "
				+ " c.cityName,c.locationType,c.photo,c.detail,IFnull(p.amount,0)\r\n"
				+ "FROM city c\r\n"
				+ "LEFT JOIN hotel h ON h.cityId = c.cityId\r\n"
				+ "LEFT JOIN product p ON p.hotelId = h.hotelId\r\n"
				+ "ORDER BY c.locationType ASC  ").getResultList();
		PackageCity pc = new PackageCity();
		List<CityDto> domeList = new ArrayList<CityDto>();
		List<CityDto> interList = new ArrayList<CityDto>();
		for(Object[] obj:objList) {
			String cityName = (String)obj[0];
			String lt = (String)obj[1];
			String photo = (String)obj[2];
			String detail = (String)obj[3];
			int amount  = Integer.parseInt(obj[4].toString());
			CityDto dto = new CityDto(cityName,lt,photo,detail,amount);
			if("DOMESTIC".equals(lt)) {
				domeList.add(dto);
			}else {
				interList.add(dto);
			}
		}
		pc.setDomestic(domeList);
		pc.setInternational(interList);
		return pc;
	}
	@Override
	  public List<CityTypeDto> getPackageByCityId(int cityId) {

	      Session session = sessionFactory.getCurrentSession();

	      List<Object[]> objList = session.createNativeQuery(
	              "SELECT c.cityId, c.cityName, c.region, c.website, c.detail,\r\n"
	            + "p.productId, p.title, p.amount, p.day, p.night,\r\n"
	            + "p.groupSize, p.type, p.photo\r\n"
	            + "FROM city c\r\n"
	            + "INNER JOIN hotel h ON h.cityId = c.cityId\r\n"
	            + "INNER JOIN product p ON p.hotelId = h.hotelId\r\n"
	            + "WHERE c.cityId = :cityId\r\n"
	            + "ORDER BY p.amount ASC")
	            .setParameter("cityId", cityId)
	            .getResultList();

	      List<ProductDto> productList = new ArrayList<>();

	      // ⭐️ ဒီစာကြောင်း ထည့်ပါ
	      List<CityTypeDto> cityDtoList = new ArrayList<>();

	      String cityName = "";
	      String region = "";
	      String website = "";
	      String detail = "";

	      for (Object[] obj : objList) {

	          cityName = (String) obj[1];
	          region = (String) obj[2];
	          website = (String) obj[3];
	          detail = (String) obj[4];

	          ProductDto dto = new ProductDto(
	                  Integer.parseInt(obj[5].toString()),
	                  null,
	                  (String) obj[12],
	                  (String) obj[6],
	                  Integer.parseInt(obj[8].toString()),
	                  Integer.parseInt(obj[9].toString()),
	                  (String) obj[10],
	                  Integer.parseInt(obj[7].toString()),
	                  cityName,
	                  0,
	                  0
	          );

	          dto.setType((String) obj[11]);

	          productList.add(dto);
	      }

	      CityTypeDto city = new CityTypeDto();

	      city.setCityId(cityId);
	      city.setCityName(cityName);
	      city.setRegion(region);
	      city.setWebsite(website);
	      city.setDetail(detail);
	      city.setProductList(productList);

	      cityDtoList.add(city);

	      // ⭐️ ဒါလည်း ထည့်ပါ
	      return cityDtoList;
	  }
}
