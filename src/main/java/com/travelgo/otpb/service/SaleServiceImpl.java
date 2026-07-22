package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.ProductDao;
import com.travelgo.otpb.dao.SaleDao;
import com.travelgo.otpb.dao.UserAccountDao;
import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.PackageDashboardDto;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private UserAccountDao userAccountDao;
    
    @Transactional(readOnly=true)
	@Override
    public List<SaleDto> getSale(String status) {

        return saleDao.getSale(status);

    }
    


	@Transactional(readOnly=false)
	@Override
    public SaleDto addSale(SaleDto dto) {

        Sale sale = new Sale(dto);

        saleDao.addSale(sale);

        return new SaleDto(sale);

    }
	
	//For AdminDashboard
	@Transactional(readOnly=true)
	@Override
    public PackageDashboardDto getPackageDashboard() {
		PackageDashboardDto dto = new PackageDashboardDto();

        Double totalRevenue = saleDao.getTotalRevenue(); 
        dto.setTotalRevenue(totalRevenue != null ? totalRevenue : 0.0);

        dto.setTotalSales(saleDao.getTotalSalesCount());

        dto.setTotalProducts(saleDao.getTotalProductsCount());

        dto.setActiveUsers(saleDao.getActiveUsersCount()); 

        dto.setInactiveUsers(saleDao.getInactiveUsersCount()); 

        
        dto.setRecentBookings(saleDao.getRecentBookings());
        dto.setTopProducts(saleDao.getTopProducts());
        dto.setMonthlyRevenues(saleDao.getMonthlyRevenue());
        return dto;
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