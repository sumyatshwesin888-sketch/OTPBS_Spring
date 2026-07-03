package com.travelgo.otpb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Comment;
@Repository
public class CommentDaoImpl implements CommentDao{
	@Autowired
	SessionFactory sessionFactory;

	public List<Comment> getComment() {
		Session session = sessionFactory.getCurrentSession();
		List<Comment> commentList =  session.createQuery("select c from Comment c ").getResultList();
		return commentList;
	}

	
	public void saveComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(comment);
	}

	
	public void updateComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.update(comment);
	}

	public void deleteComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(comment);
	}

}
