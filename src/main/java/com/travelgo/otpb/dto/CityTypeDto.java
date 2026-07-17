package com.travelgo.otpb.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityTypeDto {

    private int cityId;

    private String cityName;

    private String region;

    private String website;

    private String detail;

    private List<ProductDto> productList;

}