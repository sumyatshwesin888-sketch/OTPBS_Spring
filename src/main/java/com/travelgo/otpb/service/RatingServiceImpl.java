package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.travelgo.otpb.dao.RatingDao;
import com.travelgo.otpb.domain.Rating;
import com.travelgo.otpb.dto.RatingDto;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingDao ratingDao;

    @Transactional(readOnly = true)
    public List<RatingDto> getRating() {
        List<Rating> list = ratingDao.getRating();
        List<RatingDto> dtoList = new ArrayList<>();
        for (Rating r : list) dtoList.add(new RatingDto(r));
        return dtoList;
    }

    @Transactional
    public int addRating(RatingDto dto) {
        Rating r = new Rating(dto);
        ratingDao.saveRating(r);
        return r.getRatingId();
    }

    @Transactional
    public int updateRating(RatingDto dto) {
        Rating r = new Rating(dto);
        ratingDao.updateRating(r);
        return r.getRatingId();
    }

    @Transactional
    public int deleteRating(int ratingId) {
        Rating r = new Rating();
        r.setRatingId(ratingId);
        ratingDao.deleteRating(r);
        return ratingId;
    }
}