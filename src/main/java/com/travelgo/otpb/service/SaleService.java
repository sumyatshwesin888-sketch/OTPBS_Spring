package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.SaleDto;

public interface SaleService {

	List<SaleDto> getSale(String status);

	SaleDto addSale(SaleDto dto);

	SaleDto updateSale(SaleDto dto);

	int deleteSale(int saleId);

}
