package com.springmvc.website.dao;

import java.util.List;

import com.springmvc.website.models.Post;

public interface PostDAO {
	public void addPost(Post post);
	public void updatePost(Post post);
	public List<Post>getPosts();
	public Post getPostById(long id);
	public void removePost(Long id);
}