package com.springmvc.website.services;

import java.util.List;

import com.springmvc.website.models.Post;

public interface PostService {
	public void addPost(Post post);
	public void updatePost(Post post);
	public List<Post> ListPosts();
	public Post getPostById(int id);
	public void removePost(int id);
}
