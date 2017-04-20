package com.dao.episode;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Comment;
import com.model.Episode;

public class EpisodeDAOImpl implements EpisodesDAO {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Episode.class).buildSessionFactory();
	
	public List<Episode> getAllEpisodes() {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		List<Episode> eps = new ArrayList<Episode>();
		try {
			tx = sess.beginTransaction();
			eps = sess.createQuery("from Episode").list();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return eps;
	}

	public void addEpisode(Episode episode) {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(episode);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
	}

	public void deleteEpisode(int id) {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			Episode com = sess.load(Episode.class, id);
			if (null != com) {
				sess.delete(com);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}

	public Episode getEpisode(int id) {
		
		Episode eps = null;
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			eps = sess.load(Episode.class, id);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return eps;
	}
	
}
