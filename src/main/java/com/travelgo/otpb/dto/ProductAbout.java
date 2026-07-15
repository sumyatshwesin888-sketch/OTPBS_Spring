package com.travelgo.otpb.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class ProductAbout {
	private List<UserAccountDto> itineraryList ;
	private List<RatingDto> ratingCommentList;
	private ProductDto productDto;
}
