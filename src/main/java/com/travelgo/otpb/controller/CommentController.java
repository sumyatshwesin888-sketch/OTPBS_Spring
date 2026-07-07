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
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.CommentDto;
import com.travelgo.otpb.service.CommentServiceImpl;
@RestController
@RequestMapping("/api/v1/")
public class CommentController {
	@Autowired
	CommentServiceImpl commentService;
	
	@GetMapping("comment")
	public List<CommentDto> getComment() {
		
		return commentService.getComment();
	}
	
	@PostMapping("comment")
	public int addComment(@RequestBody CommentDto dto) {
		
		return commentService.addComment(dto);
	}
	@PutMapping("comment/{commentId}")
	public int updateComment(
			@PathVariable("commentId")int commentId,
			@RequestBody CommentDto dto) {
		dto.setCommentId(commentId);
		return commentService.updateComment(dto);
	}
	@DeleteMapping("comment/{commentId}")
	public int deleteComment(
			@PathVariable("commentId")int commentId) {
		return commentService.deleteComment(commentId);
	}
}
