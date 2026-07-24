package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Message;
import com.travelgo.otpb.dto.MessageDto;
import com.travelgo.otpb.dto.QuestionTypeDto;
@Repository
public class MessageDaoImpl implements MessageDao{
	@Autowired
	
	SessionFactory sessionFactory;

	public List<MessageDto> getMessage() {
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList =  session.createNativeQuery("SELECT q.questionTypeId,\r\n"
				+ "q.question,m.messageId,m.`name`,m.email,m.messageText,m.date \r\n"
				+ "FROM message m\r\n"
				+ "INNER JOIN questiontype q ON m.questionTypeId = q.questionTypeId").getResultList();
		List<MessageDto> dtoList = new  ArrayList<MessageDto>();
		
		for(Object[] obj:objList) {
			int questionTypeId = Integer.parseInt(obj[0].toString());
			String question = (String)obj[1];
			int messageId  = 0;
			if(obj[2]!=null)
			 messageId = Integer.parseInt(obj[2].toString());
			String name = (String)obj[3];
			String email = (String)obj[4];
			String messageText = (String)obj[5];
			Date date = null;

			if(obj[6] != null){
			    date = (Date)obj[6];
			}
			MessageDto qdto = new MessageDto(questionTypeId,question,
					messageId,name,email,messageText);
			dtoList.add(qdto);
		}
		return dtoList;
	}

	public void saveMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.save(message);		
	}

	public void updateMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.update(message);
	}

	public void deleteMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(message);
	}

	
}
