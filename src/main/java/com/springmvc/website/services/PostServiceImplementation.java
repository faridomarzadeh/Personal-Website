package com.springmvc.website.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.website.dao.PostDAO;
import com.springmvc.website.models.Post;


@Service
public class PostServiceImplementation implements PostService {
	
	private PostDAO postDAO;
	
	public void setPostDAO(PostDAO dao)
	{
		postDAO=dao;
	}
	@Override
	@Transactional
	public void addPost(Post post) {
		postDAO.addPost(post);
	}

	@Override
	@Transactional
	public void updatePost(Post post) {
		postDAO.updatePost(post);
	}

	@Override
	@Transactional
	public List<Post> ListPosts() {
		return postDAO.getPosts();
	}

	@Override
	@Transactional
	public Post getPostById(Long id) {
		// TODO Auto-generated method stub
		return postDAO.getPostById(id);
	}

	@Override
	@Transactional
	public void removePost(Long id) {
		// TODO Auto-generated method stub
		postDAO.removePost(id);
	}

}
