package com.dao.comment;

import java.util.List;

import com.model.Comment;

public interface CommentService {

	public List<Comment> listComments();
	
	public void addComment(Comment com);
	
	public void deleteComment(int id);
}
