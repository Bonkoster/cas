package com.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.model.Comment;

public interface CommentDAO {
	
	public List<Comment> getAllComments();
	
	public void addComment(Comment com);
	
	public void deleteComment(int id);
	
}
