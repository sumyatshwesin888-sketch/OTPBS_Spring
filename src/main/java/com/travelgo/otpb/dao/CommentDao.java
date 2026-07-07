package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Comment;
import com.travelgo.otpb.dto.CommentDto;

public interface CommentDao {

	List<CommentDto> getComment();

	void saveComment(Comment comment);

	void updateComment(Comment comment);

	void deleteComment(Comment comment);

}
