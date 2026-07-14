package com.travelgo.otpb.dto;

import java.util.Date;

import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.domain.QuestionType;
import com.travelgo.otpb.dto.QuestionTypeDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
//@AllArgsConstructor  
public class QuestionTypeDto {

  public QuestionTypeDto(QuestionType qT) {
    // TODO Auto-generated constructor stub
//    this.questionTypeId=qT.getQuestionTypeId();
//    this.question=qT.getQuestion();
//    this.name=qT.getName();
    
  }
  public QuestionTypeDto(int questionTypeId, String question) {
    // TODO Auto-generated constructor stub
    this.questionTypeId = questionTypeId;
    this.question = question;
//    this.messageId = messageId;
//    this.name = name;
//    this.email = email;
//    this.messageText = messageText;
    
  }


  public QuestionTypeDto(int questionTypeId) {
	// TODO Auto-generated constructor stub
	  this.questionTypeId = questionTypeId;
}


private int questionTypeId;
  private String question;
//  private int messageId;
//  private String name;
//  private String email;
//  private String messageText;



  }