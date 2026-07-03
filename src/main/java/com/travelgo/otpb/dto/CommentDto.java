package com.travelgo.otpb.dto;

import com.travelgo.otpb.domain.Comment;
import com.travelgo.otpb.dto.CommentDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class CommentDto {

	public CommentDto(Comment comment) {
		// TODO Auto-generated constructor stub
		this.commentId = comment.getCommentId();
		this.productId = comment.getProductId();
		this.message = comment.getMessage();
		this.date = comment.getDate();

	}

	private int commentId;

	private int productId;
	
	private String message;

	private Date date;

	



	}
