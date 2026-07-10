package com.travelgo.otpb.dto;

import java.io.Serializable;
import java.util.List;

import com.travelgo.otpb.domain.Itinerary;

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

	public ItineraryDto(Itinerary i) {
		// TODO Auto-generated constructor stub
		this.itineraryId = i.getItineraryId();
		this.title = i.getTitle();
		this.detail = i.getDetail();
		this.dayNo = i.getDayNo();
	}

	private int itineraryId;

	private ProductDto productDto;

	private String title;

	private String detail;

	private int dayNo;


}
