package com.springmvc.website.services;

import java.util.List;

public interface IService <T>{
	public void add(T t);
	public void update(T t);
	public List<T> getAll(String tablename);
	public T getEntitybyId(int id);
	public void remove(int id);

}
