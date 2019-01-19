package com.springmvc.website.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOImpementation<T> implements IDAO<T> {
	
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
	public List<T> getAll() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<T>entitylist=session.createQuery("From "+getClass().getName()).list();
		return entitylist;
	}

	@Override
	public T getEntitybyId(int id) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		T entity=(T) session.load(DAOImpementation.class, id);
		return entity;
	}

	@Override
	public void remove(int id) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		T entity=(T)session.load(DAOImpementation.class, id);
		if(entity!=null)
			session.delete(entity);
	}

}
