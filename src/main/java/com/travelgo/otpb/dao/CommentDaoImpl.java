package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.travelgo.otpb.dto.ProductDto;
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
				+ "    p.title AS productTitle,\r\n"
				+ "    c.date\r\n"
				+ "FROM comment c\r\n"
				+ "LEFT JOIN product p ON c.productId = p.productId;").getResultList();
				
				
				
		List<CommentDto> dtoList = new  ArrayList<CommentDto>();
		for(Object[] obj:objList) {
			CommentDto cdto = new CommentDto();

		    cdto.setCommentId(
		        Integer.parseInt(obj[0].toString())
		    );

		    cdto.setMessage(
		        (String)obj[1]
		    );


		    ProductDto product = new ProductDto();

		    product.setTitle(
		        (String)obj[2]
		    );

		    cdto.setProduct(product);


		    cdto.setDate(
		        (Date)obj[3]
		    );


		    dtoList.add(cdto);
		}
		return dtoList;
	}

	
	public void saveComment(Comment comment) {
		  System.out.println("COMMENT INSERT START");
		Session session = sessionFactory.getCurrentSession();
		session.save(comment);
		System.out.println("COMMENT INSERT END");
	}

	
	public void updateComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.update(comment);
	}

	public void deleteComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(comment);
	}


	public Comment findById(int commentId) {
		 Session session =
			        sessionFactory.getCurrentSession();


			    return session.get(
			        Comment.class,
			        commentId
			    );
	}

}
