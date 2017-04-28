package com.dao.comment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.model.Comment;
import com.model.Episode;

public interface CommentDAO {
	
	public long getCount();
	
	public List<Comment> getPageComments(int page);
	
	public void addComment(Comment com);
	
	public void deleteComment(int id);
	
}
