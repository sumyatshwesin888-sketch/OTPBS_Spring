package com.travelgo.otpb.dto;

import java.util.Date;

import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.This;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class ProductDto{
	
	public ProductDto(int travelers, int packages, int cities) {
		this.traveler = travelers;
	    this.packages = packages;
	    this.cities = cities;
	}
	public ProductDto(int productId, String locationType, String photo, String title, int day, int night,
			String groupSize, int amount, String location, double ratingCount, int commentCount) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.photo = photo;
		this.title = title;
		this.day = day;
		this.night = night;
		this.groupSize = groupSize;
		this.amount = amount;
		this.location = location;
		this.ratingCount = ratingCount;
		this.locationType = locationType;
		this.commentCount = commentCount;
	}
	public ProductDto(int productId, String pTitle) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.title = pTitle;
	}
	
	public ProductDto(int productId, String title, String location, int amount, int day, int night,
			Date travelDate, int ticket, String groupSize, String meals, double ratingCount, int commentCount,
			String photoOne, String photoTwo, String photoThree, String photoFour, String detail,
			String transport) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.title = title;
		this.location = location;
		this.amount = amount;
		this.day = day;
		this.night = night;
		this.travelDate = travelDate;
		this.ticket = ticket;
		this.groupSize = groupSize;
		this.meals = meals;
		this.ratingCount = ratingCount;
		this.commentCount = commentCount;
		this.photoOne = photoOne;
		this.photoTwo = photoTwo;
		this.photoThree = photoThree;
		this.photoFour = photoFour;
		this.detail =detail;
		this.transport = transport;
	}

	private int productId;
	private int userAccountId;
	private int traveler;
	private int packages;
	private int cities;
	private HotelDto hotelDto;
	private String photo;
	private String title;
	private String location;
	private int day;
	private int night;
	private String groupSize;
	private int amount;
	private String type;
	private String meals;
	private String photoOne;
	private String photoTwo;
	private String photoThree;
	private String photoFour;
	private int hotelId;
	private String hotelName;
	private String detail;
	private Date travelDate;
	private int ticket;
	private double ratingCount;
	private int comment;
	private String locationType;
	private int commentCount;
	private ItineraryDto itineraryDto;
	private int leftTicket;
	private String transport;
	private int saleCount;
	private int photoCount;
	public void setPackageId(int packageId) {
		// TODO Auto-generated method stub
		
	}
	public ProductDto(int product) {
		// TODO Auto-generated constructor stub
		this.amount = product;
	}

	public ProductDto getProductId() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setProductId(int productId2) {
		// TODO Auto-generated method stub
		
	}
	public void setType(String type2) {
		// TODO Auto-generated method stub
	}

	public ProductDto(int productId, String title, String location, int amount, int day, int night,
			Date travelDate, int ticket, String groupSize, String meals, double ratingCount, int commentCount,
			String photoOne, String photoTwo, String photoThree, String photoFour, int hotelId, String hotelName,
			String detail, String transport, int saleCount, int leftTicket,String photo,String locationType) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.title = title;
		this.location = location;
		this.amount = amount;
		this.day = day;
		this.night = night;
		this.travelDate = travelDate;
		this.ticket = ticket;
		this.groupSize = groupSize;
		this.meals = meals;
		this.ratingCount = ratingCount;
		this.commentCount = commentCount;
		this.photoOne = photoOne;
		this.photoTwo = photoTwo;
		this.photoThree = photoThree;
		this.photoFour = photoFour;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.detail =detail;
		this.transport = transport;
		this.saleCount = saleCount;

	}
	public ProductDto(Product product) {
		// TODO Auto-generated constructor stub

		this.leftTicket = leftTicket;
		this.photo = photo;
		this.locationType = locationType;
	}
	public ProductDto(String title, String type, String locationType, String location, int day, int night,
			String groupSize, String meals, Date travelDate, int ticket, String transport, int amount,
			String photo, String photoOne, String photoTwo, String photoThree, String photoFour) {
		// TODO Auto-generated constructor stub
		//this.productId = productId;
		this.title = title;
		this.location = location;
		this.amount = amount;
		this.day = day;
		this.night = night;
		this.travelDate = travelDate;
		this.ticket = ticket;
		this.groupSize = groupSize;
		this.meals = meals;
		this.photoOne = photoOne;
		this.photoTwo = photoTwo;
		this.photoThree = photoThree;
		this.photoFour = photoFour;
		this.transport = transport;
		this.photo = photo;
		this.locationType = locationType;
		this.type = type;
	}

	
	
	}
	
	
