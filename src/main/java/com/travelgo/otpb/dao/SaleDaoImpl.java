package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.MonthlyRevenueDto;
import com.travelgo.otpb.dto.PackageDashboardDto;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.dto.TopProductDto;

@Repository
@Transactional
public class SaleDaoImpl implements SaleDao {
	@Autowired
	 private SessionFactory sessionFactory;



    @Override

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
    }

    //For AdminDashboard
    @Override
    public Integer getTotalSalesCount() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT COUNT(*) FROM sale";
        Object result = session.createNativeQuery(sql).getSingleResult();
        return result != null ? Integer.parseInt(result.toString()) : 0;
    }

    @Override
    public Double getTotalRevenue() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT COALESCE(SUM(amount), 0) FROM sale";
        Object result = session.createNativeQuery(sql).getSingleResult();
        return result != null ? Double.parseDouble(result.toString()) : 0.0;
    }

    @Override
    public Integer getTotalProductsCount() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT COUNT(*) FROM product";
        Object result = session.createNativeQuery(sql).getSingleResult();
        return result != null ? Integer.parseInt(result.toString()) : 0;
    }

    @Override
    public Integer getActiveUsersCount() {
        Session session = sessionFactory.getCurrentSession();
       
        String sql = "SELECT COUNT(*) FROM useraccount WHERE status = 'ACTIVE' OR status = '1'";
        Object result = session.createNativeQuery(sql).getSingleResult();
        return result != null ? Integer.parseInt(result.toString()) : 0;
    }

    @Override
    public Integer getInactiveUsersCount() {
        Session session = sessionFactory.getCurrentSession();
       
        String sql = "SELECT COUNT(*) FROM useraccount WHERE status = 'INACTIVE' OR status = '0'";
        Object result = session.createNativeQuery(sql).getSingleResult();
        return result != null ? Integer.parseInt(result.toString()) : 0;
    }
    
    
 // Recent Bookings
    public List<SaleDto> getRecentBookings() {
        Session session = sessionFactory.getCurrentSession();
        List<Object[]> objList = session.createNativeQuery(
            "SELECT s.saleId, ua.userAccountId, ua.profileName, p.productId, p.title, " +
            "s.qty, s.unitPrice, s.amount, s.paymentType, s.`status`, s.date, s.modifiedDate, s.voucherCode " +
            "FROM sale s " +
            "LEFT JOIN useraccount ua ON ua.userAccountId = s.customerId " +
            "LEFT JOIN product p ON p.productId = s.productId " +
            "ORDER BY s.date DESC LIMIT 5"
        ).getResultList();

        List<SaleDto> dtoList = new ArrayList<>();
        for(Object[] obj : objList) {
            int saleId = Integer.parseInt(obj[0].toString());
            int userAccountId = Integer.parseInt(obj[1].toString());
            int customerId = userAccountId;
            String profileName = obj[2] != null ? obj[2].toString() : "";
            int productId = Integer.parseInt(obj[3].toString());
            String title = obj[4] != null ? obj[4].toString() : "";
            int qty = Integer.parseInt(obj[5].toString());
            int unitPrice = Integer.parseInt(obj[6].toString());
            int amount = Integer.parseInt(obj[7].toString());
            String paymentType = obj[8] != null ? obj[8].toString() : "";
            String st = obj[9] != null ? obj[9].toString() : "";
            Date date = (Date) obj[10];
            Date modifiedDate = (Date) obj[11];
            String voucherCode = obj[12] != null ? obj[12].toString() : "";

            dtoList.add(new SaleDto(saleId, userAccountId, customerId, profileName, productId, title, qty, unitPrice, amount, paymentType, st, date, modifiedDate, voucherCode));
        }
        return dtoList;
    }

    // Top Products
    public List<TopProductDto> getTopProducts() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT p.productId, p.title, COALESCE(p.location, 'Myanmar'), COALESCE(SUM(s.qty), 0) as totalQty " +
                     "FROM product p " +
                     "LEFT JOIN sale s ON p.productId = s.productId AND s.status != 'DELETE' " +
                     "GROUP BY p.productId, p.title, p.location " +
                     "ORDER BY totalQty DESC LIMIT 5";

        List<Object[]> objList = session.createNativeQuery(sql).getResultList();
        List<TopProductDto> list = new ArrayList<>();
        for(Object[] obj : objList) {
            int productId = Integer.parseInt(obj[0].toString());
            String title = obj[1] != null ? obj[1].toString() : "";
            String location = obj[2] != null ? obj[2].toString() : "Myanmar";
            long count = Long.parseLong(obj[3].toString());
            list.add(new TopProductDto(productId, title, location, count));
        }
        return list;
    }

    // Monthly Revenue Breakdown
    public List<MonthlyRevenueDto> getMonthlyRevenue() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT DATE_FORMAT(s.date, '%b') as mName, MONTH(s.date) as mNum, COALESCE(SUM(s.amount), 0) " +
                     "FROM sale s " +
                     "WHERE s.status != 'DELETE' AND s.date IS NOT NULL " +
                     "GROUP BY mName, mNum " +
                     "ORDER BY mNum ASC";

        List<Object[]> objList = session.createNativeQuery(sql).getResultList();
        List<MonthlyRevenueDto> list = new ArrayList<>();
        for(Object[] obj : objList) {
            String month = obj[0].toString();
            double amount = Double.parseDouble(obj[2].toString());
            list.add(new MonthlyRevenueDto(month, amount));
        }
        return list;

    }
   

    @Override
    public void addSale(Sale sale) {
    	Session session = sessionFactory.getCurrentSession();
        
    	session.save(sale);
    }

    @Override
    public void updateSale(Sale sale) {

    	 Session session = sessionFactory.getCurrentSession();

         
    	    session.update(sale);


    }

    @Override
    public void deleteSale(int saleId) {

       Session session = sessionFactory.getCurrentSession();
        Sale sale = session.get(Sale.class, saleId);

        if (sale != null) {
            session.delete(sale);
        }

    }

	@Override
	public Integer getUserCountByStatus(String string) {
		// TODO Auto-generated method stub
		return null;
	}





}

