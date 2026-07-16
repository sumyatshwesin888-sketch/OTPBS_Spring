package com.travelgo.otpb.dto;

import java.util.Date;

import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class ProductDto{
	
	public ProductDto(Product p) {
		// TODO Auto-generated constructor stub
		this.title  = p.getTitle();
		this.day = p.getDay();
		this.night = p.getNight();
		this.amount = p.getAmount();
		this.photo = p.getPhoto();
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
	private int userAccount;
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
	public void setPackageId(int packageId) {
		// TODO Auto-generated method stub
		
	}
	public ProductDto(int amount) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
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
		this.leftTicket = leftTicket;
		this.photo = photo;
		this.locationType = locationType;
	}
	
	
	}
	
	
