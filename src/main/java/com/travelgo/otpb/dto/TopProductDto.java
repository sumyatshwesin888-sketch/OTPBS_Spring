package com.travelgo.otpb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopProductDto {
    private Integer productId;
    private String title;
    private String location;
    private Long count; 
}