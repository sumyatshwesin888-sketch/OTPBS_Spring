package com.travelgo.otpb.dto;

import java.io.Serializable;

import com.travelgo.otpb.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class ItineraryDto {

	public ItineraryDto(int itineraryId, String title, String detail, int dayNo) {
		// TODO Auto-generated constructor stub
		this.itineraryId = itineraryId;
		this.title = title;
		this.detail = detail;
		this.dayNo = dayNo;
	}

	public ItineraryDto(int dayNo, String itineraryTitle, String itineraryDetail) {
		// TODO Auto-generated constructor stub
		this.dayNo = dayNo;
		this.title = itineraryTitle;
		this.detail = itineraryDetail;
	}

	private int itineraryId;

	private int productId;

	private String title;

	private String detail;

	private int dayNo;

	public int getProductId() {
		// TODO Auto-generated method stub
		return productId;
	}
	public void setProductId(int productId) {
		this.productId=productId;
	}

}
