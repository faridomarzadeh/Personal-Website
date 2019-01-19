package com.springmvc.website.dao;

import java.util.List;

public interface IDAO <T>{
	public void add(T t);
	public void update(T t);
	public List<T> getAll();
	public T getEntitybyId(int id);
	public void remove(int id);

}
