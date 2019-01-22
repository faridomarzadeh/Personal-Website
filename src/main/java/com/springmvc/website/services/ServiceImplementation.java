package com.springmvc.website.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springmvc.website.dao.IDAO;
@Service
public class ServiceImplementation<T> implements IService<T> {
	private IDAO<T> iDAO;
	
	public void setIDAO(IDAO idao)
	{
		this.iDAO=idao;
	}
	
	@Transactional
	@Override
	public void add(T t) {
		iDAO.add(t);
	}
	
	@Transactional
	@Override
	public void update(T t) {
		iDAO.update(t);
	}
	
	@Transactional
	@Override
	public List<T> getAll(String tablename) {
		// TODO Auto-generated method stub
		return iDAO.getAll(tablename);
	}

	@Transactional
	@Override
	public T getEntitybyId(int id) {
		// TODO Auto-generated method stub
		return iDAO.getEntitybyId(id);
	}

	@Transactional
	@Override
	public void remove(int id) {
		iDAO.remove(id);
	}
	
	@Transactional
	@Override
	public T getResultByQuery(String query) {
		return iDAO.getResultByQuery(query);
	}

	@Transactional
	@Override
	public List<T> getResultsByQuery(String query) {
		return iDAO.getResultsByQuery(query);
	}

}
