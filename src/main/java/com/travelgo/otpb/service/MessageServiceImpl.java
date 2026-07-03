package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.MessageDaoImpl;
import com.travelgo.otpb.dao.MessageDao;
import com.travelgo.otpb.domain.Message;
import com.travelgo.otpb.dto.MessageDto;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDaoImpl messageDao;

	
	@Transactional(readOnly=true)
	@Override
	public List<MessageDto> getMessage() {
		// TODO Auto-generated method stub
		List<Message> messageList = messageDao.getMessage();
		List<MessageDto> dtoList = new ArrayList<MessageDto>();
		for(Message message:messageList) {
			MessageDto dto = new MessageDto(message);
			dtoList.add(dto);
		}
		return dtoList;
	}

	
	@Transactional(readOnly=false)
	public int addMessage(MessageDto dto) {
		// TODO Auto-generated method stub
		Message message = new Message(dto);
		messageDao.saveMessage(message);
		return message.getMessageId();
	}

	@Transactional(readOnly=false)
	
	public int updateMessage(MessageDto dto) {
		// TODO Auto-generated method stub
		Message message = new Message(dto);
		messageDao.updateMessage(message);
		return message.getMessageId();
	}

	
	@Transactional(readOnly=false)
	
	public int deleteMessage(int messageId) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setMessageId(messageId);
		messageDao.deleteMessage(message);
		return messageId;
	}

	
	
}
