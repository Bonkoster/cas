package com.dao.episode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Comment;
import com.model.Episode;

public class EpisodeDAOImpl implements EpisodesDAO {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Episode.class).buildSessionFactory();
	
	public List<Episode> getAllEpisodes(int page) {
		
		int first = 0;
		
		for (int i=1;i<page;i++) {
			first = first + 10;
		}
		
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		List<Episode> eps = new ArrayList<Episode>();
		try {
			tx = sess.beginTransaction();
			Query query = sess.createQuery("FROM Episode");
			query.setFirstResult(first);
			query.setMaxResults(10);
			eps = query.getResultList();
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
			tx.rollback();
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
			tx.rollback();
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

	public long getCount() {		
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		long i = 0;
		try {
			tx = sess.beginTransaction();
			i = (Long) sess.createQuery("select count(*) from Episode").uniqueResult();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return i;
	}
	
}
