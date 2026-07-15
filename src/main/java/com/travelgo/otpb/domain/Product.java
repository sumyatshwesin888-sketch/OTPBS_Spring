package com.travelgo.otpb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.ProductDto;

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
	}
	public Product(int productId, String pTitle) {
		// TODO Auto-generated constructor stub
		this.productId=productId;
		this.title=pTitle;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		}
	
	
