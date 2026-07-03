package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.QuestionTypeDao;
import com.travelgo.otpb.dao.QuestionTypeDaoImpl;
import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.domain.Message;
import com.travelgo.otpb.domain.QuestionType;
import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.MessageDto;
import com.travelgo.otpb.dto.QuestionTypeDto;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
	@Autowired
	QuestionTypeDao questionTypeDao;

	@Transactional(readOnly=true)
	@Override
	public List<QuestionTypeDto> getQuestionType() {
		// TODO Auto-generated method stub
//		List<QuestionType> questionTypeList = questionTypeDao.getQuestionType();
//		List<QuestionTypeDto> dtoList = new ArrayList<QuestionTypeDto>();
//		for(QuestionType questionType:questionTypeList) {
//			QuestionTypeDto dto = new QuestionTypeDto(questionType);
//			dtoList.add(dto);
//		}
		return questionTypeDao.getQuestionType();
	}

	@Transactional(readOnly=false)
	@Override
	public int addQuestionType(QuestionTypeDto dto) {
		QuestionType questionType = new QuestionType(dto);
		questionTypeDao.saveQuestionType(questionType);
		return questionType.getQuestionTypeId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateQuestionType(QuestionTypeDto dto) {
		// TODO Auto-generated method stub
		QuestionType questionType = new QuestionType(dto);
		questionTypeDao.updateQuestionType(questionType);
		return questionType.getQuestionTypeId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteQuestionType(int questionTypeId) {
		QuestionType questionType = new QuestionType();
		questionType.setQuestionTypeId(questionTypeId);
		questionTypeDao.deleteQuestionType(questionType);
		return questionTypeId;
	}

	
	
	
}
