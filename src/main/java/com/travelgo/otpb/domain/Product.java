package com.travelgo.otpb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.util.ConvertDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "product")
public class Product{
	
	public Product(ProductDto dto) {
		// TODO Auto-generated constructor stub
		this.productId = dto.getProductId();
		this.userAccountId = 1;//dto.getUserAccountId();
		this.hotelId = 1;//dto.getHotelId();
		this.photo = dto.getPhoto();
		this.title = dto.getTitle();
		this.location = dto.getLocation();
		this.day = dto.getDay();
		this.night = dto.getNight();
		this.groupSize = dto.getGroupSize();
		this.amount = dto.getAmount();
		this.type = "Budget";//dto.getType();
		this.meals = dto.getMeals();
		this.photoOne = dto.getPhotoOne();
		this.photoTwo = dto.getPhotoTwo();
		this.photoThree = dto.getPhotoThree();
		this.photoFour = dto.getPhotoFour();
		this.detail = dto.getDetail();
		System.out.println(dto.getType()+" >>>>>>>>>>> "+dto.getTravelDate());
		this.travelDate = ConvertDate.convertDateToStringYearMonthDay(dto.getTravelDate());
		this.ticket = dto.getTicket();
		this.transport = dto.getTransport();
		
	}
	public Product(int productId, String pTitle) {
		// TODO Auto-generated constructor stub
		this.productId=productId;
		this.title=pTitle;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private int userAccountId;
	private int hotelId;
	@Column(name="photo")
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
	private String travelDate;
	private int ticket;
	private String transport;
	
}
	
	
