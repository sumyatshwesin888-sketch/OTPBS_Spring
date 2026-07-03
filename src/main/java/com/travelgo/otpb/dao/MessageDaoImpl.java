package com.travelgo.otpb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelgo.otpb.domain.Message;
@Repository
public class MessageDaoImpl implements MessageDao{
	@Autowired
	SessionFactory sessionFactory;

	public List<Message> getMessage() {
		Session session = sessionFactory.getCurrentSession();
		List<Message> messageList =  session.createQuery("select m from Message m ").getResultList();
		return messageList;
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
