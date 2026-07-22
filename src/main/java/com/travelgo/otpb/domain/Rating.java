package com.travelgo.otpb.domain;

import javax.persistence.*;

import com.travelgo.otpb.dto.RatingDto;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
    private int customerId;
    private int productId;
    private int rating;
    private Date date;

    public Rating() {
    	super();
    }

    public Rating(RatingDto dto) {
        this.ratingId = dto.getRatingId();
        this.productId = dto.getProductId();
        this.rating = dto.getRating();
        this.date = new Date();
        this.customerId = dto.getUserAccountDto().getUserAccountId();
    }

    // Getters and Setters
    public Integer getRatingId() { return ratingId; }
    public void setRatingId(Integer ratingId) { this.ratingId = ratingId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

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

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}