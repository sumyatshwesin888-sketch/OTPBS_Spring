package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.MessageDto;

public interface MessageService {

	List<MessageDto> getMessage();

	int addMessage(MessageDto dto);

	int updateMessage(MessageDto dto);

	int deleteMessage(int messageId);

}
