package com.travelgo.otpb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import com.travelgo.otpb.dto.CommentDto;

import lombok.Data;
@Data
@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentId;
	private String message;
	

	private String title;


	private Date date;
	private int customerId;
	public Comment(CommentDto dto) {
		this.commentId = dto.getCommentId();
		this.message = dto.getMessage();

//		this.profileName = dto.getProfileName();
		this.title = dto.getTitle();

		this.date = dto.getDate();
		this.customerId = dto.getUserAccountDto().getUserAccountId();

	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}






	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setProductId(int productId) {
		// TODO Auto-generated method stub
		
	}

	public void setDate(Date date2) {
		// TODO Auto-generated method stub
		
	}

	public int getProductId() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}