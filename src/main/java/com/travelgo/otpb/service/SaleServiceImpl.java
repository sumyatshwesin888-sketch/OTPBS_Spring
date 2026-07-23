package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.SaleDao;
import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;

    @Transactional(readOnly=true)
	@Override
    public List<SaleDto> getSale(String status) {

        return saleDao.getSale(status);

    }

	@Transactional(readOnly=false)
	@Override
    public SaleDto addSale(SaleDto dto) {

		
		System.out.println("===== SALE INSERT =====");
	    System.out.println(dto.getCustomerId());
	    System.out.println(dto.getProductId());
	    System.out.println(dto.getQty());
	    System.out.println(dto.getUnitPrice());
	    System.out.println(dto.getPaymentType());


        Sale sale = new Sale(dto);

        saleDao.addSale(sale);

        return new SaleDto(sale);

    }

	@Transactional(readOnly=false)

	@Override
    public SaleDto updateSale(SaleDto dto) {

        Sale sale = new Sale(dto);

        saleDao.updateSale(sale);

        return new SaleDto(sale);

    }

	@Transactional(readOnly=false)

	@Override
    public int deleteSale(int saleId) {

        saleDao.deleteSale(saleId);

        return saleId;

    }

}