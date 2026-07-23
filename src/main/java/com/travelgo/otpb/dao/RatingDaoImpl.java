package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Rating;
import com.travelgo.otpb.dto.RatingDto;

@Repository
public class RatingDaoImpl implements RatingDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Rating> getRating() {
        Session session = sessionFactory.getCurrentSession();
        // HQL query
        List<Rating> ratingList = session.createQuery("select r from Rating r").getResultList();
        return ratingList;
    }

    @Override
    public void saveRating(Rating rating) {
        Session session = sessionFactory.getCurrentSession();
        session.save(rating);
    }

    @Override
    public void updateRating(Rating rating) {
        Session session = sessionFactory.getCurrentSession();
        session.update(rating);
    }

    @Override
    public void deleteRating(Rating rating) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(rating);
    }

	@Override
	public List<RatingDto> getRatingCommentByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT  ua.profileName,r.rating,r.date,c.message\r\n"
				+ "FROM rating r\r\n"
				+ "LEFT JOIN `comment` c ON c.productId = r.productId\r\n"
				+ "LEFT JOIN useraccount ua ON ua.userAccountId = r.customerId\r\n"
				+ "WHERE r.productId = :productId order by r.ratingId DESC ").setParameter("productId", productId).getResultList();
		List<RatingDto>  dtoList = new ArrayList<RatingDto>();
		for(Object[] obj:objList) {
			String profileName = (String)obj[0];
			int rating  = Integer.parseInt(obj[1].toString());
			Date date = (Date)obj[2];
			String message = (String)obj[3];
			RatingDto dto = new RatingDto(profileName,rating,date,message);
			dtoList.add(dto);
		}
		return dtoList;
	}
}