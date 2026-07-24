package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.MonthlyRevenueDto;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.dto.TopProductDto;

public interface SaleDao {

    List<SaleDto> getSale(String status);

    void addSale(Sale sale);

    void updateSale(Sale sale);

    void deleteSale(int saleId);

	Integer getTotalSalesCount();

	Double getTotalRevenue();
	
	Integer getTotalProductsCount();

    Integer getActiveUsersCount();

    Integer getInactiveUsersCount();

	Integer getUserCountByStatus(String string);

	List<SaleDto> getRecentBookings();

	List<TopProductDto> getTopProducts();

	List<MonthlyRevenueDto> getMonthlyRevenue();

	
	

}