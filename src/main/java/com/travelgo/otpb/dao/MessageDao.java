package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Message;

public interface MessageDao {

	List<Message> getMessage();

	void saveMessage(Message message);

	void updateMessage(Message message);

	void deleteMessage(Message message);


}
