package com.travelgo.otpb.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;
import com.travelgo.otpb.util.DateTimeFormatSerializer;
import com.travelgo.otpb.domain.Message;
import com.travelgo.otpb.dto.MessageDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class MessageDto {

	public MessageDto(Message message) {
		// TODO Auto-generated constructor stub
		this.messageId = message.getMessageId();
		this.questionType = new QuestionTypeDto(message.getQuestionTypeId());
		this.name = message.getName();
		this.email = message.getEmail();
		this.messageText = message.getMessageText();
		this.date = message.getDate();

	}

	private int messageId;
	private QuestionTypeDto questionType;
	private String name;
	private String email;
	private String messageText;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
	private Date date;

	}
