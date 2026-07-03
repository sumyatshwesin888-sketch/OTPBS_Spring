package com.travelgo.otpb.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;

    private Integer productId;
    private Integer rating;
    private LocalDateTime date;

    public Rating() {}

    public Rating(com.travelgo.otpb.dto.RatingDto dto) {
        this.ratingId = dto.getRatingId();
        this.productId = dto.getProductId();
        this.rating = dto.getRating();
        this.date = dto.getDate();
    }

    // Getters and Setters
    public Integer getRatingId() { return ratingId; }
    public void setRatingId(Integer ratingId) { this.ratingId = ratingId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}