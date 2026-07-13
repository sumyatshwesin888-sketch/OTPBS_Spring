package com.travelgo.otpb.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Product> productList =  session.createQuery("select p from Product p ").getResultList();
		return productList;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}
	
	
//	for product detail Page for real
	@Override
	public ProductDto getProductDetail(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT p.productId,p.title, p.location, p.amount, p.`day`, p.night, p.travelDate, p.ticket, p.groupSize, p.meals,\r\n"
				+ "AVG(r.rating) AS ratingCount, (cm.commentId) AS commentCount, p.photoone, p.photoTwo, p.photoThree,\r\n"
				+ "p.photoFour,\r\n"
				+ "h.hotelId, h.hotelName, p.detail, p.transport,\r\n"
				+ "COUNT(distinct s.saleId ) AS saleCount,p.photo,c.locationType\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
				+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
				+ "WHERE p.productId = :productId\r\n"
				+ "GROUP BY p.productId").setParameter("productId", productId).getResultList();
		
		ProductDto dto = new ProductDto();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			productId = Integer.parseInt(obj[0].toString());
			String title = (String)obj[1];
			String location = (String)obj[2];
			int amount = Integer.parseInt(obj[3].toString());
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			Date travelDate  = (Date)obj[6];
			int ticket = Integer.parseInt(obj[7].toString());
			String groupSize = (String)obj[8];
			String meals = (String)obj[9];
	
			double ratingCount = obj[10] != null ? Double.parseDouble(obj[10].toString()) : 0.0;
			
			int commentCount = obj[11] != null ? Integer.parseInt(obj[11].toString()) : 0;
			
			String photoOne = (String)obj[12];
			String photoTwo = (String)obj[13];
			String photoThree = (String)obj[14];
			String photoFour = (String)obj[15];
			int hotelId = obj[16] != null ? Integer.parseInt(obj[16].toString()) : 0;
			String hotelName = (String)obj[17];
			String detail = (String)obj[18];
			String transport = (String)obj[19];
			int saleCount = Integer.parseInt(obj[20].toString());
			int leftTicket = ticket - saleCount;
			String photo = (String)obj[21];
			String locationType = (String)obj[22];
			
			dto = new ProductDto(productId,title,location,amount,day,night,travelDate,
					ticket,groupSize,meals,ratingCount,commentCount,photoOne,photoTwo,
					photoThree,photoFour,hotelId, hotelName,detail,transport,saleCount,leftTicket,photo,locationType);
		}
		return dto;
	}

}
