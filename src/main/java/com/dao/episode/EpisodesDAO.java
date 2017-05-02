package com.dao.episode;

import java.util.List;

import com.model.Episode;

public interface EpisodesDAO {
	
	public List<Episode> getAllEpisodes();
	
	public void addEpisode(Episode episode);
	
	public void deleteEpisode (int id);
	
	public Episode getEpisode(int id);
	
	public long getCount();
}
