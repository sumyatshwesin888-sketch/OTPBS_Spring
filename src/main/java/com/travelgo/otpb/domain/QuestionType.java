package com.travelgo.otpb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.QuestionTypeDto;

@Entity
@Table(name = "questionType")
public class QuestionType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionTypeId;
	private String question;

	public QuestionType(QuestionTypeDto dto) {
		// TODO Auto-generated constructor stub
		this.questionTypeId = dto.getQuestionTypeId();
		this.question = dto.getQuestion();
	}

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType() {
		// TODO Auto-generated constructor stub
	}

	}
