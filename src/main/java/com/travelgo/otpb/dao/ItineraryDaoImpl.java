package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Itinerary;
import com.travelgo.otpb.dto.ItineraryDto;
import com.travelgo.otpb.dto.ProductDto;

@Repository
public class ItineraryDaoImpl implements ItineraryDao{
	@Autowired
    SessionFactory sessionFactory;

	@Override
	public List<ItineraryDto> getItineray() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT it.itineraryId, it.productId, p.title AS pTitle, it.title AS itTitle, it.detail, it.dayNo\r\n"
				+ "FROM itinerary it\r\n"
				+ "LEFT JOIN product p ON p.productId = it.productId\r\n"
				+ "ORDER BY it.dayNo").getResultList();
		List<ItineraryDto> dtoList = new  ArrayList<ItineraryDto>();
		for(Object[] obj:objList) {
			int itineraryId = Integer.parseInt(obj[0].toString());
			int productId = Integer.parseInt(obj[1].toString());
			String pTitle = (String)obj[2];
			String title = (String)obj[3];
			String detail = (String)obj[4];
			int dayNo = Integer.parseInt(obj[5].toString());
			
			
			ItineraryDto dto = new ItineraryDto(itineraryId,title,detail,dayNo);
			dto.setProductDto(new ProductDto(productId,pTitle));
			dtoList.add(dto);
		}
		
		
		
		return dtoList;
	}

	@Override
	public void addItinerary(Itinerary i) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	     session.save(i);
	}

	@Override
	public void updateItinerary(Itinerary i) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	     session.update(i);
	}

	@Override
	public void deleteItinerary(Itinerary i) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	     session.delete(i);
	}

	

}
