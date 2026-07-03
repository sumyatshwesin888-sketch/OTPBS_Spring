package com.travelgo.otpb.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.ItineraryDto;

@Entity
@Table(name = "itinerary")
public class Itinerary {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itineraryId;

	private int productId;

	private String title;

	private String detail;

	private int dayNo;
	
	public Itinerary() {
		super();
	}

	public Itinerary(ItineraryDto dto) {
		// TODO Auto-generated constructor stub
		this.itineraryId = dto.getItineraryId();
		this.title = dto.getTitle();
		this.detail = dto.getDetail();
		this.dayNo = dto.getDayNo();
		this.productId = dto.getProductDto().getProductId();
		
	}

	public int getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(int itineraryId) {
		this.itineraryId = itineraryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getDayNo() {
		return dayNo;
	}

	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}
	
	

}
