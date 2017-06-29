package com.dao.comment;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Repository;

import com.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {
	

	public static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Comment.class).buildSessionFactory();

	public List<Comment> getPageComments(int page) {
		int first = 0;
		
		for (int i=1;i<page;i++) {
			first = first + 5;
		}
		
		Session sess = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List<Comment> coms = new ArrayList<Comment>();
		try {
			tx = sess.beginTransaction();
			Query query = sess.createQuery("FROM Comment");
			query.setFirstResult(first);
			query.setMaxResults(5);
			coms = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return coms;
	}

	public void deleteComment(int id) {
		Session sess = sessionFactory.getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			Comment com = sess.load(Comment.class, id);
			if (null != com) {
				sess.delete(com);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
	}

	public void addComment(Comment com) {
		Session sess = sessionFactory.getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(com);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}

	public long getCount() {
		
		long i = 0;
		Session sess = sessionFactory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			i =  (Long) sess.createQuery("select count(*) from Comment").uniqueResult(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return i;
	}

}
