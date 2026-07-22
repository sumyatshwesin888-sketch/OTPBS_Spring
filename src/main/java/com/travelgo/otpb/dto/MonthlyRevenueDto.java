package com.travelgo.otpb.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class MonthlyRevenueDto {
    private String month;
	private double amount;
	public MonthlyRevenueDto(String month, double amount) {
		// TODO Auto-generated constructor stub
    	this.month = month;
    	this.amount= amount;
	}
	private Integer totalSales;
    private Double totalRevenue;
    private Integer totalProducts;
    private Integer activeUsers;
    private Integer inactiveUsers;
    
    

    
}