package com.travelgo.otpb.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.QuestionTypeDto;
import com.travelgo.otpb.service.QuestionTypeServiceImpl;

@RestController
@RequestMapping("/api/v1/")
public class QuestionTypeController {
	@Autowired
	QuestionTypeServiceImpl questionTypeService;
	
	@GetMapping("questionType")
	public List<QuestionTypeDto> getQuestionType() {
		
		return questionTypeService.getQuestionType();
	}
	
	@PostMapping("questionType")
	public int addQuestionType(@RequestBody QuestionTypeDto dto) {
		
		return questionTypeService.addQuestionType(dto);
	}
	@PutMapping("questionType/{questionTypeId}")
	public int updateQuestionType(
			@PathVariable("questionTypeId")int questionTypeId,
			@RequestBody QuestionTypeDto dto) {
		dto.setQuestionTypeId(questionTypeId);
		return questionTypeService.updateQuestionType(dto);
	}
	@DeleteMapping("questionType/{questionTypeId}")
	public int deleteQuestionType(
			@PathVariable("questionTypeId")int questionTypeId) {
		return questionTypeService.deleteQuestionType(questionTypeId);
	}
}
