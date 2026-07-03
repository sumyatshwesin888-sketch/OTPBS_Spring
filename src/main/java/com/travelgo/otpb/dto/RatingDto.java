package com.travelgo.otpb.dto;

import com.travelgo.otpb.domain.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private int ratingId;
    private int productId;
    private int rating;
    private LocalDateTime date;

    public RatingDto(Rating rating) {
        this.ratingId = rating.getRatingId();
        this.productId = rating.getProductId();
        this.rating = rating.getRating();
        this.date = rating.getDate();
    }
}