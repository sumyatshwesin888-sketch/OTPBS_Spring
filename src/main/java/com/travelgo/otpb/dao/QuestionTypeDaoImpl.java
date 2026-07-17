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
		List<Object[]> objList = session.createQuery("select q.id, q.question from QuestionType q").getResultList();
		List<QuestionTypeDto> dtoList = new ArrayList<QuestionTypeDto>();
	    
	    for(Object[] obj : objList) {   
	        int questionTypeId = Integer.parseInt(obj[0].toString());
	        String question = (String) obj[1];
	        
	        QuestionTypeDto dto = new QuestionTypeDto( questionTypeId, question);
	        dtoList.add(dto);
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
