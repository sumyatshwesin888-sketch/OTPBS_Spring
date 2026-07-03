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

import com.travelgo.otpb.dto.MessageDto;
import com.travelgo.otpb.service.MessageServiceImpl;
@RestController
@RequestMapping("/api/v1/")
public class MessageController {
	@Autowired
	MessageServiceImpl messageService;
	
	@GetMapping("message")
	public List<MessageDto> getMessage() {
		
		return messageService.getMessage();
	}
	
	@PostMapping("message")
	public int addMessage(@RequestBody MessageDto dto) {
		
		return messageService.addMessage(dto);
	}
	@PutMapping("message/{messageId}")
	public int updateMessage(
			@PathVariable("messageId")int messageId,
			@RequestBody MessageDto dto) {
		dto.setMessageId(messageId);
		return messageService.updateMessage(dto);
	}
	@DeleteMapping("message/{messageId}")
	public int deleteMessage(
			@PathVariable("messageId")int messageId) {
		return messageService.deleteMessage(messageId);
	}
}
