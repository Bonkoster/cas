package com.dao.episode;

import java.util.List;

import com.model.Episode;

public class EpisodeServiceImpl implements EpisodeService {

	EpisodeDAOImpl epDAO = new EpisodeDAOImpl();
	
	public List<Episode> listComments() {
		return epDAO.getAllEpisodes();
	}

	public void addComment(Episode episode) {
		epDAO.addEpisode(episode);
		
	}

	public void deleteComment(int id) {
		epDAO.deleteEpisode(id);		
	}

}
