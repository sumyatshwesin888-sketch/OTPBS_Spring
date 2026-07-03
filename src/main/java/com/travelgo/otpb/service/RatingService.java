package com.travelgo.otpb.service;

import java.util.List;
import com.travelgo.otpb.dto.RatingDto;

public interface RatingService {
    List<RatingDto> getRating();
    int addRating(RatingDto dto);
    int updateRating(RatingDto dto);
    int deleteRating(int ratingId);
}