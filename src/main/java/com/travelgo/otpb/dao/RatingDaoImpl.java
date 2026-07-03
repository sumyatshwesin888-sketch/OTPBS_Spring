package com.travelgo.otpb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Rating;

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
}