package com.springmvc.website.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
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
		session.persist(t);
		
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

}
