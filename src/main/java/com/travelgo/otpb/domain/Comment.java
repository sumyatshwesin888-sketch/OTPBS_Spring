package com.travelgo.otpb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import com.travelgo.otpb.dto.CommentDto;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentId;
	private int productId;
	private String message;
	private Date date;
	private int customerId;
	public Comment(CommentDto dto) {
		this.commentId = dto.getCommentId();
		this.productId = dto.getProductId();
		this.message = dto.getMessage();
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}