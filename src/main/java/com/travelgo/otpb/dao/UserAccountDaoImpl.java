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
    public List<UserAccount> getUserAccount(String userType,String search) {
        Session session = sessionFactory.getCurrentSession();
        // HQL query to retrieve all UserAccount entities
        String sqlWhere = "WHERE 1=1 ";
        if(!search.equals("")) {
        	sqlWhere+= " AND u.profileName like  '%"+search+"%'";
        }else {
        	if(!"ALL".equals(userType)) {
        		sqlWhere += " AND u.userType= '"+userType+"'";
        	}
        }
        List<UserAccount> userAccountList = session.createQuery("select u from UserAccount u "
        		+sqlWhere+" order by u.profileName ASC ")
        		.getResultList();
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
        Object userAccountId = null;
		session.createNativeQuery("UPDATE useraccount SET profileName = :profileName, phone = :phone WHERE useraccountId = :id ")
		.setParameter("profileName", userAccount.getProfileName())
        .setParameter("phone", userAccount.getPhone())
        .setParameter("id", userAccount.getUserAccountId())
        .executeUpdate();
       // session.update(userAccount);
    }
    @Override
    public void updatePassword(int userAccountId, String newPassword) {
        Session session = sessionFactory.getCurrentSession();
        session.createNativeQuery("UPDATE useraccount SET password = :password WHERE useraccountId = :id")
               .setParameter("password", newPassword)
               .setParameter("id", userAccountId)
               .executeUpdate();
//        session.update(userAccount);
    }
    @Override
    public void deleteUserAccount(UserAccount userAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(userAccount);
    }

	@Override
	public UserAccount getUserAccountById(int userAccountId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.find(UserAccount.class, userAccountId);
	}

	@Override
	public UserAccountDto getUserHome() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList =session.createNativeQuery("SELECT COUNT(u.userAccountId) AS  allCount,\r\n"
				+ "SUM(IF(u.userType='ADMIN',1,0)) AS adminCount,\r\n"
				+ " SUM(IF(u.userType='CUSTOMER',1,0)) AS customerCount,\r\n"
				+ " SUM(IF(u.status=1,1,0)) AS activeCount,\r\n"
				+ " SUM(IF(u.status=0,1,0)) AS inactiveCount\r\n"
				+ "FROM useraccount u").getResultList();
		UserAccountDto dto = new UserAccountDto();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			int allCount = Integer.parseInt(obj[0].toString());
			int adminCount = Integer.parseInt(obj[1].toString());
			int custCount = Integer.parseInt(obj[2].toString());
			int activeCount = Integer.parseInt(obj[3].toString());
			int inactiveCount = Integer.parseInt(obj[4].toString());
			dto.setAllCount(allCount);
			dto.setAdminCount(adminCount);
			dto.setCustomerCount(custCount);
			dto.setActiveCount(activeCount);
			dto.setInactiveCount(inactiveCount);
		}
		
		return dto;
	}

	@Override
	public Integer getUserCountByStatus(String string) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<UserAccount> getUserAccount() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
    
}