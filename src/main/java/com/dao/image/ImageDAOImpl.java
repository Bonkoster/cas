package com.dao.image;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.model.Episode;
import com.model.Image;

public class ImageDAOImpl implements ImageDAO {
	
	SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Image.class).buildSessionFactory();
	
	public List<Image> getGallery(int page) {		
		int first = 0;
		
		for (int i=1;i<page;i++) {
			first = first + 20;
		}
		
		Session sess = sessionfactory.openSession();
		Transaction tx = null;
		List<Image> imgs = new ArrayList<Image>();
		try {
			tx = sess.beginTransaction();
			Query query = sess.createQuery("FROM Image");
			query.setFirstResult(first);
			query.setMaxResults(20);
			imgs = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return imgs;
	}

	public void addImage(Image file) {
		Session sess = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.save(file);
			tx.commit();						
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
	}

	public void deleteimage(int id) {
		Session sess = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			Image im = sess.load(Image.class, id);
			if (im != null) {
				sess.delete(im);
			}
			tx.commit();						
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
	}

	public Image getImage(int id) {
		Image eps = null;
		Session sess = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			eps = sess.load(Image.class, id);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return eps;
	}

	public long getCount() {
		Session sess = sessionfactory.openSession();
		Transaction tx = null;
		long i = 0;
		try {
			tx = sess.beginTransaction();
			i = (Long) sess.createQuery("select count(*) from Image").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return i;
	}

}
