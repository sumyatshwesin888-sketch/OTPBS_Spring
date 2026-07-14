package com.travelgo.otpb.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travelgo.otpb.domain.Rating;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;
import com.travelgo.otpb.util.DateTimeFormatSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private int ratingId;
    private int productId;
    private int rating;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
    private Date date;
    private String  comment;
    private UserAccountDto userAccountDto;

    public RatingDto(Rating rating) {
        this.ratingId = rating.getRatingId();
        this.productId = rating.getProductId();
        this.rating = rating.getRating();
        this.date = rating.getDate();
    }

	public RatingDto(String profileName, int rating, Date date, String message) {
		// TODO Auto-generated constructor stub
		this.userAccountDto = new UserAccountDto(profileName);
		this.rating = rating;
		this.date = date;
		this.comment = message;
	}
}