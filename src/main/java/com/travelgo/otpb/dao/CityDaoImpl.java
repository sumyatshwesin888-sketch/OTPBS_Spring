package com.travelgo.otpb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.UserAccountDto;
@Repository
public class CityDaoImpl implements CityDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<City> getCity() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<City> cityList =  session.createQuery("select c from City c ").getResultList();
		return cityList;
	}

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

	

}
