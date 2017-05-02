package com.dao.episode;

import java.util.List;

import com.model.Episode;

public class EpisodeServiceImpl implements EpisodeService {

	EpisodeDAOImpl epDAO = new EpisodeDAOImpl();
	
	public List<Episode> listEpisode() {
		return epDAO.getAllEpisodes();
	}

	public void addEpisode(Episode episode) {
		epDAO.addEpisode(episode);
		
	}

	public void deleteEpisode(int id) {
		epDAO.deleteEpisode(id);		
	}

	public Episode getEpisode(int id) {
		return epDAO.getEpisode(id);
	}

	public long getCount() {
		// TODO Auto-generated method stub
		return epDAO.getCount();
	}

}
