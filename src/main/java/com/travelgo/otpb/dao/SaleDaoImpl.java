package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

<<<<<<< HEAD
=======
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

>>>>>>> fe62644ab973cd019cfc07ce6cd97243748ac8eb
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.SaleDto;

@Repository
@Transactional
public class SaleDaoImpl implements SaleDao {
	@Autowired
	 private SessionFactory sessionFactory;

	@Autowired
	SessionFactory sessionFactory;

    @Override
<<<<<<< HEAD
    public List<SaleDto> getSale(String status) {
    	Session session = sessionFactory.getCurrentSession();
    	String sqlWhere = " WHERE 1=1 ";
    	if(!"All".equals(status)) {
    		sqlWhere+= " AND s.status= '"+status+"'";
    	}
    	
    	List<Object[]> objList = session.createNativeQuery("SELECT s.saleId,ua.userAccountId,"
    			+ "ua.profileName,"
    			+ "p.productId,p.title,s.qty,s.unitPrice,s.amount,\r\n"
    			+ "s.paymentType,s.`status`,s.date,s.modifiedDate,s.voucherCode\r\n"
    			+ "FROM sale s\r\n"
    			+ "LEFT JOIN useraccount ua ON ua.userAccountId = s.customerId     \r\n"
    			+ "LEFT JOIN product p ON p.productId = s.productId "+sqlWhere).getResultList();
    	List<SaleDto>  dtoList = new ArrayList<SaleDto>();
    	for(Object[] obj:objList) {
    		int saleId = Integer.parseInt(obj[0].toString());
    		int customerId = Integer.parseInt(obj[1].toString());
    		String profileName = (String)obj[2];
    		int productId = Integer.parseInt(obj[3].toString());
    		String title = (String)obj[4];
    		int qty = Integer.parseInt(obj[5].toString());
    		int unitPrice = Integer.parseInt(obj[6].toString());
    		int amount = Integer.parseInt(obj[7].toString());
    		String paymentType = (String)obj[8];
    		status = (String)obj[9];
    		Date date = (Date)obj[10];
    		Date modifiedDate = (Date)obj[11];
    		String voucherCode = (String)obj[12];
    		SaleDto dto =   new SaleDto(saleId,customerId,profileName,productId,title,qty,unitPrice,
    				amount,paymentType,status,date,modifiedDate,voucherCode);
    		dtoList.add(dto);
    	}
    	
        return dtoList;
=======
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
		
    	
>>>>>>> fe62644ab973cd019cfc07ce6cd97243748ac8eb
    }

    @Override
    public void addSale(Sale sale) {
    	Session session = sessionFactory.getCurrentSession();
        //entityManager.persist(sale);
    	session.save(sale);
    }

    @Override
    public void updateSale(Sale sale) {

       // entityManager.merge(sale);

    }

    @Override
    public void deleteSale(int saleId) {

//        Sale sale = entityManager.find(Sale.class, saleId);
//
//        if (sale != null) {
//
//            entityManager.remove(sale);
//
//        }

    }

}