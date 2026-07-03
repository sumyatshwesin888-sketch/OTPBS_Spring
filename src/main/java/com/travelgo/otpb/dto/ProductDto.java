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
	
	public ProductDto(Product product) {
		// TODO Auto-generated constructor stub
	}
	public ProductDto(int productId, String locationType, String photo, 
			String title, int day, int night,
			String groupSize, int amount, String location, double ratingCount) {
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
	}
	public ProductDto(int productId, String pTitle) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.title = pTitle;
	}
	private int productId;
	private int userAccount;
	private int hotelId;
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
	private String detail;
	private Date travelDate;
	private int ticket;
	private double ratingCount;
	private int comment;//(112)
	private String locationType;
	}
	
	
