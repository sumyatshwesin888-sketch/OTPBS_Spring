package com.travelgo.otpb.dao;

import java.util.List;
import com.travelgo.otpb.dto.QuestionTypeDto;

import com.travelgo.otpb.domain.QuestionType;

public interface QuestionTypeDao {

	List<QuestionTypeDto> getQuestionType();

	void saveQuestionType(QuestionType questionType);

	void updateQuestionType(QuestionType questionType);

	void deleteQuestionType(QuestionType questionType);
}
