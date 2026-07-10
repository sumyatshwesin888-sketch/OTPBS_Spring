package com.travelgo.otpb.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travelgo.otpb.domain.Comment;
import com.travelgo.otpb.dto.CommentDto;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;
import com.travelgo.otpb.util.DateTimeFormatSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor 
public class CommentDto {

	public CommentDto(Comment comment) {
		// TODO Auto-generated constructor stub
		
	}

	public CommentDto(int commentId, String message, String profileName, String email, String title) {
		// TODO Auto-generated constructor stub
		this.commentId = commentId;
		this.message = message;
		this.profileName=profileName;
		this.email=email;
		this.title = title;
		

	}


	private int commentId;


	private String message;
	
	private String profileName;

	private String email;

	private String title;

	private int productId;
	private UserAccountDto userAccountDto;
	//private String message;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
	private Date date;

	



	}
