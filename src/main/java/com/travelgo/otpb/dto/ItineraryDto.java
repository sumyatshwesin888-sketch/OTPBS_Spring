package com.travelgo.otpb.dto;

import java.io.Serializable;

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

	private int itineraryId;

	private ProductDto productDto;

	private String title;

	private String detail;

	private int dayNo;

}
