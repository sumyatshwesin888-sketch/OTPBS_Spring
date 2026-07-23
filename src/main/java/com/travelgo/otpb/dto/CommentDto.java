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
		this.commentId = comment.getCommentId();
		this.customerId = comment.getCustomerId();
		this.productId = comment.getProductId();
		this.message = comment.getMessage();
		this.date = comment.getDate();
		this.userAccountDto = null;

		 if(comment.getProduct()!=null){
	            this.product = new ProductDto(comment.getProduct());
	        }
		
	}




	private int commentId;
	private int customerId;
	private int productId;
	private UserAccountDto userAccountDto;

	private String message;
	private ProductDto product;
	
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
	private Date date;


	
	



	}
