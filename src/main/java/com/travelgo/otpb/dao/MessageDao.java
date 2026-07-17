package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Message;
import com.travelgo.otpb.dto.MessageDto;

public interface MessageDao {

	List<MessageDto> getMessage();

	void saveMessage(Message message);

	void updateMessage(Message message);

	void deleteMessage(Message message);


}
