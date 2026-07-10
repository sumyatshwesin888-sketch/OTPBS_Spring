package com.travelgo.otpb.dao;

import java.util.List;
import com.travelgo.otpb.domain.Rating;
import com.travelgo.otpb.dto.RatingDto;

public interface RatingDao {

    List<Rating> getRating();

    void saveRating(Rating rating);

    void updateRating(Rating rating);

    void deleteRating(Rating rating);

	List<RatingDto> getRatingCommentByProductId(int productId);
}