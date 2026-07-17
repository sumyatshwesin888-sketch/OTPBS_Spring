package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.SaleDto;

public interface SaleDao {

    List<SaleDto> getSale(String status);

    void addSale(Sale sale);

    void updateSale(Sale sale);

    void deleteSale(int saleId);

}