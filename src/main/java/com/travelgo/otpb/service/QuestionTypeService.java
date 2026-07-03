package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.QuestionTypeDto;

public interface QuestionTypeService {

	List<QuestionTypeDto> getQuestionType();

	int addQuestionType(QuestionTypeDto dto);

	int updateQuestionType(QuestionTypeDto dto);

	int deleteQuestionType(int questionTypeId);


}
