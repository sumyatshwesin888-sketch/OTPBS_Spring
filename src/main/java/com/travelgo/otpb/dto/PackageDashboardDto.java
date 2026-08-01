package com.travelgo.otpb.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class PackageDashboardDto {
    private Integer totalSales;
    private Double totalRevenue=0.0;
    private Integer totalProducts;
    private Integer activeUsers;
    private Integer inactiveUsers;
    
    private List<SaleDto> recentBookings;
    private List<TopProductDto> topProducts;
    private List<MonthlyRevenueDto> monthlyRevenues;

    private int approved;
    private int confirm;
    private int cancel;
    
}