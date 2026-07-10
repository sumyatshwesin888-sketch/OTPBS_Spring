package com.travelgo.otpb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.MessageDto;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int messageId;
	private int questionTypeId;
	private String name;
	private String email;
	private String messageText;
	private Date date;
	
	public Message(MessageDto dto) {
		// TODO Auto-generated constructor stub
		this.messageId = dto.getMessageId();
		this.questionTypeId = dto.getQuestionType().getQuestionTypeId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.messageText = dto.getMessageText();
		this.date = new Date();
		
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	


	
	

	}
