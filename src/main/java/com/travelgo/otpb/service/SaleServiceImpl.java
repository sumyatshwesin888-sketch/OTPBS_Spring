package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelgo.otpb.dao.SaleDao;
import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;

   
	@Override
    public List<SaleDto> getSale() {

        return saleDao.getSale();

    }

    
	@Override
    public SaleDto addSale(SaleDto dto) {

        Sale sale = new Sale(dto);

        saleDao.addSale(sale);

        return new SaleDto(sale);

    }

  
	@Override
    public SaleDto updateSale(SaleDto dto) {

        Sale sale = new Sale(dto);

        saleDao.updateSale(sale);

        return new SaleDto(sale);

    }

   
	@Override
    public int deleteSale(int saleId) {

        saleDao.deleteSale(saleId);

        return saleId;

    }

}