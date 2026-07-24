package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.travelgo.otpb.domain.Hotel;
import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.HotelDto;
import com.travelgo.otpb.dto.ItineraryDto;
import com.travelgo.otpb.dto.ProductDto;

@Repository
public class HotelDaoImpl implements HotelDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<HotelDto> getHotel(String hotelName,String cityName,String search) {
        Session session = sessionFactory.getCurrentSession();
        String sqlWhere = "WHERE h.status = 'ACTIVE' ";
        //String sqlWhere = "WHERE 1=1 ";
        if (search != null && !search.trim().equals("")) {
            sqlWhere += " AND h.hotelName LIKE '%" + search.trim() + "%'";
        } else {
            if (cityName != null && !"ALL".equals(cityName)) {
                sqlWhere += " AND c.cityName = '" + cityName + "'";
            }
        }
        String sql="SELECT h.hotelId, h.hotelName, c.cityId, c.cityName "+ " FROM hotel h LEFT JOIN city c ON c.cityId = h.cityId " 
                + sqlWhere 
                + " ORDER BY h.hotelName";
        List<Object[]> objList = session.createNativeQuery(sql).getResultList();
        List<HotelDto> dtoList = new ArrayList<HotelDto>();
        
        for(Object[] obj : objList) {
        	int hId = obj[0] != null ? Integer.parseInt(obj[0].toString()) : 0;
            String htName = obj[1] != null ? obj[1].toString() : "";
            int cId = obj[2] != null ? Integer.parseInt(obj[2].toString()) : 0;
            String cName = obj[3] != null ? obj[3].toString() : "N/A";

            HotelDto dto = new HotelDto();
            dto.setHotelId(hId);
            dto.setHotelName(htName);
            
            CityDto city = new CityDto();
            city.setCityId(cId);
            city.setCityName(cName);
            dto.setCityDto(city);
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
    public boolean deleteHotel(int hotelId) {
        Session session = sessionFactory.getCurrentSession();
        
        // DELETE Query အစား UPDATE Query ပြောင်းရေး
        String sql = "UPDATE hotel SET status = 'DELETED' WHERE hotelId = :hId";
        int result = session.createNativeQuery(sql)
                            .setParameter("hId", hotelId)
                            .executeUpdate();
                            
        return result > 0; // Update အဆင်ပြေရင် true ပြန်ပေးမည်
    }
//
//	@Override
//	public List<HotelDto> getHotel() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//@Override
//public List<HotelDto> getHotel() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public void deleteHotel(Hotel hotel) {
//	// TODO Auto-generated method stub
//	
//}

//@Override
//public boolean deleteHotel(Hotel hotel) {
//	// TODO Auto-generated method stub
//	return false;
//}

//@Override
//public void deleteHotel(Hotel hotel) {
//	// TODO Auto-generated method stub
//	
//}

//	@Override
//	public void deleteHotel(Hotel hotel) {
//		// TODO Auto-generated method stub
//		
//	}
}