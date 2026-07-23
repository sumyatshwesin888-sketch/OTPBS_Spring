package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.CommentDaoImpl;
import com.travelgo.otpb.domain.Comment;
import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.CommentDto;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDaoImpl commentDao;
	
	
	@Transactional(readOnly=true)
	public List<CommentDto> getComment() {
//		
		return commentDao.getComment();
	}
//	
	
	@Transactional(readOnly=false)
	public int addComment(CommentDto dto) {
		Comment comment = new Comment(dto);
		if (dto.getUserAccountDto() != null) {
			comment.setCustomerId(dto.getUserAccountDto().getUserAccountId());
		}
		
		commentDao.saveComment(comment);
		return comment.getCommentId();
	}
	
	@Transactional(readOnly=false)
	public int updateComment(CommentDto dto) {
		Comment comment = new Comment(dto);
		
		if (dto.getUserAccountDto() != null) {
			comment.setCustomerId(dto.getUserAccountDto().getUserAccountId());
		}
		
		commentDao.updateComment(comment);
		return comment.getCommentId();
	}
	
	@Transactional(readOnly=false)
	
	public int deleteComment(int commentId) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setCommentId(commentId);
		commentDao.deleteComment(comment);
		return commentId;
	}
	@Override
	public int addCity(CityDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
