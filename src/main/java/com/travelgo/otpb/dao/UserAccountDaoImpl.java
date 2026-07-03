package com.travelgo.otpb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.UserAccountDto;

@Repository
public class UserAccountDaoImpl implements UserAccountDao {
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
	public UserAccountDto login(String email, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<UserAccount> userList =  session.createQuery("select ua from UserAccount ua where "
				+ " ua.email = :email and ua.password = :password ")
				.setParameter("email", email).setParameter("password", password).getResultList();
		UserAccountDto dto =  new UserAccountDto();
		if(userList.size()>0) {
			UserAccount ua = userList.get(0);
			dto = new UserAccountDto(ua);
		}
		return dto;
	}

    @Override
    public List<UserAccount> getUserAccount() {
        Session session = sessionFactory.getCurrentSession();
        // HQL query to retrieve all UserAccount entities
        List<UserAccount> userAccountList = session.createQuery("select u from UserAccount u").getResultList();
        return userAccountList;
    }

    @Override
    public void saveUserAccount(UserAccount userAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userAccount);
    }

    @Override
    public void updateUserAccount(UserAccount userAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userAccount);
    }

    @Override
    public void deleteUserAccount(UserAccount userAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(userAccount);
    }

//	@Override
//	public List<UserAccount> getUserAccount() {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
}