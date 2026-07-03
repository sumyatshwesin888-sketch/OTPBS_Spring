package com.travelgo.otpb.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CityTypeDto {
	private String cityName;
	private List<ProductDto> productList;
}
