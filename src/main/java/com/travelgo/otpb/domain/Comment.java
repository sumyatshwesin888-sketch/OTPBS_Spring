package com.travelgo.otpb.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date date;
	private int customerId;
	private int productId;

	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(
	        name="productId",
	        insertable=false,
	        updatable=false
	    )
	    private Product product;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Product getProduct(){
		 return product;
		}
	
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		// TODO Auto-generated method stub
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
		
	}

	public void setDate(Date date) {
		// TODO Auto-generated method stub
		 this.date = date;
	}

	
	}

	

