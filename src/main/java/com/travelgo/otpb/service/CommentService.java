package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.CommentDto;

public interface CommentService {

	List<CommentDto> getComment();
	
	int addCity(CityDto dto);

	int updateComment(CommentDto dto);

	int deleteComment(int commentId);

}
