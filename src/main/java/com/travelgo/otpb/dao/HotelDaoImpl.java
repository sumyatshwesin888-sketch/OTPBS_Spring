package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.travelgo.otpb.domain.Hotel;
import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.HotelDto;
import com.travelgo.otpb.dto.ItineraryDto;
import com.travelgo.otpb.dto.ProductDto;

@Repository
public class HotelDaoImpl implements HotelDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<HotelDto> getHotel() {
        Session session = sessionFactory.getCurrentSession();
        List<Object[]> objList = session.createNativeQuery("SELECT h.hotelId , c.cityId, c.cityName , h.hotelName\r\n"
        		+ "FROM hotel h\r\n"
        		+ "LEFT JOIN city c ON c.cityId = h.hotelId\r\n"
        		+ "ORDER BY h.hotelName").getResultList();
        List<HotelDto> dtoList = new  ArrayList<HotelDto>();
		for(Object[] obj:objList) {
			int hotelId = Integer.parseInt(obj[0].toString());
			int cityId = Integer.parseInt(obj[1].toString());
			String cityName = (String)obj[2];
			String hotelName = (String)obj[3];
			
			
			
			HotelDto dto = new HotelDto(hotelId,hotelName);
			dto.setCityDto(new CityDto(cityId,cityName));
			dtoList.add(dto);
		}
		
		return dtoList;
    }

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hotel);
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(hotel);
    }
}