package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Comment;
import com.travelgo.otpb.dto.CommentDto;
import com.travelgo.otpb.dto.QuestionTypeDto;
@Repository
public class CommentDaoImpl implements CommentDao{
	@Autowired
	SessionFactory sessionFactory;

	public List<CommentDto> getComment() {
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT \r\n"
				+ "    c.commentId,\r\n"
				+ "    c.message,\r\n"
				+ "    u.profileName AS customerName,\r\n"
				+ "    u.email AS customerEmail,\r\n"
				+ "    p.title AS productTitle\r\n"
				+ "FROM comment c\r\n"
				+ "LEFT JOIN userAccount u ON c.customerId = u.userAccountId\r\n"
				+ "LEFT JOIN product p ON c.productId = p.productId;").getResultList();
		List<CommentDto> dtoList = new  ArrayList<CommentDto>();
		for(Object[] obj:objList) {
			int commentId = Integer.parseInt(obj[0].toString());
			String message = (String)obj[1];
			String profileName = (String)obj[2];
			String email = (String)obj[3];
			String title = (String)obj[4];
			CommentDto cdto = new CommentDto(commentId,message,
					profileName,email,title);
			dtoList.add(cdto);
		}
		return dtoList;
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
