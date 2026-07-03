package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.QuestionType;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.QuestionTypeDto;
@Repository
public class QuestionTypeDaoImpl implements QuestionTypeDao{

	@Autowired
	SessionFactory sessionFactory;
	public List<QuestionTypeDto> getQuestionType() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT q.questionTypeId,\r\n"
				+ "q.question,m.messageId,m.`name`,m.email,m.messageText\r\n"
				+ "FROM questiontype q\r\n"
				+ "LEFT JOIN message m ON m.questionTypeId = q.questionTypeId").getResultList();
		List<QuestionTypeDto> dtoList = new  ArrayList<QuestionTypeDto>();
		for(Object[] obj:objList) {
			int questionTypeId = Integer.parseInt(obj[0].toString());
			String question = (String)obj[1];
			int messageId  = 0;
			if(obj[2]!=null)
			 messageId = Integer.parseInt(obj[2].toString());
			String name = (String)obj[3];
			String email = (String)obj[4];
			String messageText = (String)obj[5];
			QuestionTypeDto qdto = new QuestionTypeDto(questionTypeId,question,
					messageId,name,email,messageText);
			dtoList.add(qdto);
		}
		return dtoList;
	}
	
	public void saveQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(questionType);
	}
	
	public void updateQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(questionType);
		
	}
	
	public void deleteQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(questionType);
	}


}
