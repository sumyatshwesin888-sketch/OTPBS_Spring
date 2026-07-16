package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.SaleDao;
import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.SaleDto;

@Repository
@Transactional
public class SaleDaoImpl implements SaleDao {
	@Autowired
	 private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SaleDto> getSale() {

    	Session session = sessionFactory.getCurrentSession();
    	String  sql = "SELECT s.saleId, s.userAccountId, s.customerId, s.productId, \r\n"
    			+ "s.voucherCode, s.qty, s.unitPrice, s.amount, s.paymentType, s.status \r\n"
    			+ "FROM sale s \r\n"
    			+ "LEFT JOIN product p ON s.productId = p.productId";
    	
    	
    	List<Object[]> objList = session.createNativeQuery(sql).getResultList();
        List<SaleDto> dtoList = new ArrayList<>();
        
        for (Object[] obj : objList) {
          
        	int saleId = Integer.parseInt(obj[0].toString());
        	int userAccountId = Integer.parseInt(obj[1].toString());
        	int customerId = Integer.parseInt(obj[2].toString());
        	int productId = Integer.parseInt(obj[3].toString());
        	String voucherCode = (String)obj[4];
        	int qty = Integer.parseInt(obj[5].toString());
        	int unitPrice = Integer.parseInt(obj[6].toString());
        	int amount = Integer.parseInt(obj[7].toString());

        	String paymentType = (String)obj[8];
        	SaleDto dto = new SaleDto(saleId,userAccountId,customerId,voucherCode,qty,unitPrice,amount,paymentType);
			dto.setProductDto(new ProductDto(productId));
			dtoList.add(dto);       }
//        List<Sale> list = entityManager
//                .createQuery("FROM Sale", Sale.class)
//                .getResultList();
//
//        List<SaleDto> dtoList = new ArrayList<>();
//
//        for (Sale sale : list) {
//            dtoList.add(new SaleDto(sale));
//        }
//
//        return dtoList;
		return dtoList;
		
    	
    }

    @Override
    public void addSale(Sale sale) {

        entityManager.persist(sale);

    }

    @Override
    public void updateSale(Sale sale) {

        entityManager.merge(sale);

    }

    @Override
    public void deleteSale(int saleId) {

        Sale sale = entityManager.find(Sale.class, saleId);

        if (sale != null) {

            entityManager.remove(sale);

        }

    }

}