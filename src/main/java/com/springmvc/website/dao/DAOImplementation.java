package com.springmvc.website.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.springmvc.website.models.User;
@Repository
public class DAOImplementation<T> implements IDAO<T> {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}

	@Override
	public void add(T t) {
		Session session=sessionFactory.getCurrentSession();
		session.save(t);
		/*Transaction tx = null;
		System.out.print("entered2222222222222");
	    try {
	        tx = session.beginTransaction();
	        session.save(t);
	        tx.commit(); // Flush happens automatically
	    }
	    catch (RuntimeException e) {
	        tx.rollback();
	        throw e; // or display error message
	    }
	    finally {
	        session.close();
	    }*/
		
	}

	@Override
	public void update(T t) {
		Session session=sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	public List<T> getAll(String tablename) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<T>entitylist=session.createQuery("From "+tablename).list();
		return entitylist;
	}

	@Override
	public T getEntitybyId(int id) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		T entity=(T) session.load(DAOImplementation.class, id);
		return entity;
	}

	@Override
	public void remove(int id) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		T entity=(T)session.load(DAOImplementation.class, id);
		if(entity!=null)
			session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getResultByQuery(String query) {
		Session session=sessionFactory.getCurrentSession();
		T entity=(T)session.createQuery(query);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getResultsByQuery(String query) {
		Session session=sessionFactory.getCurrentSession();
		List<T> entities=session.createQuery(query).list();
		return entities;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getByUsername(String username){
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.createQuery("From User where username='"+username+"'").uniqueResult();
		return user;
	}

}
