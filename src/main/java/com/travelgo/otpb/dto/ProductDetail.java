package com.travelgo.otpb.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class ProductDetail {
	private List<ItineraryDto> itineraryList ;
	private List<RatingDto> ratingCommentList;
	private ProductDto productDto;
}
