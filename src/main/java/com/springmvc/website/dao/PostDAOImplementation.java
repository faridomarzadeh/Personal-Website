package com.springmvc.website.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springmvc.website.models.Post;
@Repository
public class PostDAOImplementation implements PostDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PostDAOImplementation.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}

	@Override
	public void addPost(Post post) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(post);
		logger.info("Post Saved Successfully, Post Details= "+post.toString());
	}

	@Override
	public void updatePost(Post post) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(post);
		logger.info("Post Updated successfully, Post Details= "+post.toString());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPosts() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Post>listpost=session.createQuery("From Post").list();
		for(Post p :listpost)
			logger.info("Post List"+p.toString());
		
		return listpost;
	}

	@Override
	public Post getPostById(long id) {
		Session session=this.sessionFactory.getCurrentSession();
		Post post=(Post)session.load(Post.class, id);
		logger.info("Post Loaded successfully, Post Details="+post);
		return post;
	}

	@Override
	public void removePost(Long id) {
		Session session=this.sessionFactory.getCurrentSession();
		Post post=(Post)session.load(Post.class, id);
		if(post!=null)
			session.delete(post);
		logger.info("Post Deleted successfully, Post Details="+post);
	}

}
