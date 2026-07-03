package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Comment;

public interface CommentDao {

	List<Comment> getComment();

	void saveComment(Comment comment);

	void updateComment(Comment comment);

	void deleteComment(Comment comment);

}
