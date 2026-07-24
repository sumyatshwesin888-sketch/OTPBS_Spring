package com.travelgo.otpb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.UserAccountDto;
@Repository
public class CityDaoImpl implements CityDao{
	@Autowired
	SessionFactory sessionFactory;

//	@Override
//	public List<City> getCity() {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		List<City> cityList =  session.createQuery("select c from City c ").getResultList();
//		return cityList;
//	}
	@Override
	public List<City> getCity(String cityName, String search) {
	    Session session = sessionFactory.getCurrentSession();
	    String sql = "SELECT * FROM city WHERE 1=1 ";
	    if (cityName != null && !"ALL".equals(cityName)) {
	        sql += " AND cityName = :cityName ";
	    }
	    if (search != null && !search.equals("")) {
	        sql += " AND cityName LIKE :search ";
	    }
	    NativeQuery<City> query = session.createNativeQuery(sql, City.class);
	    
	    if (cityName != null && !"ALL".equals(cityName)) {
	        query.setParameter("cityName", cityName);
	    }
	    if (search != null && !search.equals("")) {
	        query.setParameter("search", "%" + search + "%"); 
	    }
	    
	    return query.getResultList();
	}
//	 @Override
//	    public List<UserAccount> getUserAccount(String userType,String search) {
//	        Session session = sessionFactory.getCurrentSession();
//	        // HQL query to retrieve all UserAccount entities
//	        String sqlWhere = "WHERE 1=1 ";
//	        if(!search.equals("")) {
//	        	sqlWhere+= " AND u.profileName like  '%"+search+"%'";
//	        }
	@Override
	public void saveCity(City city) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(city);
	}

	@Override
	public void updateCity(City city) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(city);
	}

	@Override
	public void deleteCity(City city) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(city);
	}

	@Override
	public UserAccountDto login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<City> getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
