package com.travelgo.otpb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.travelgo.otpb.dto.RatingDto;
import com.travelgo.otpb.service.RatingService;

@RestController
@RequestMapping("/api/v1/")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping("rating")
    public List<RatingDto> getRating() { return ratingService.getRating(); }

    @PostMapping("rating")
    public int addRating(@RequestBody RatingDto dto) { return ratingService.addRating(dto); }

    @PutMapping("rating/{ratingId}")
    public int updateRating(@PathVariable("ratingId") int ratingId, @RequestBody RatingDto dto) {
        dto.setRatingId(ratingId);
        return ratingService.updateRating(dto);
    }

    @DeleteMapping("rating/{ratingId}")
    public int deleteRating(@PathVariable("ratingId") int ratingId) { return ratingService.deleteRating(ratingId); }
}