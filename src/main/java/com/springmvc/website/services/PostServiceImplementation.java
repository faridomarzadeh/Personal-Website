package com.springmvc.website.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.website.dao.PostDAO;
import com.springmvc.website.models.Post;

public class PostServiceImplementation implements PostService {
	
	@Autowired
	private PostDAO postdao;

	@Override
	@Transactional
	public void addPost(Post post) {
		postdao.addPost(post);
	}

	@Override
	@Transactional
	public void updatePost(Post post) {
		postdao.updatePost(post);
	}

	@Override
	@Transactional
	public List<Post> ListPosts() {
		return postdao.getPosts();
	}

	@Override
	@Transactional
	public Post getPostById(Long id) {
		// TODO Auto-generated method stub
		return postdao.getPostById(id);
	}

	@Override
	@Transactional
	public void removePost(Long id) {
		// TODO Auto-generated method stub
		postdao.removePost(id);
	}

}
