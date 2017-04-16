package com.dao.episode;

import java.util.List;

import com.model.Episode;



public interface EpisodeService {
	
	public List<Episode> listComments();
	
	public void addComment(Episode episode);
	
	public void deleteComment(int id);
}
