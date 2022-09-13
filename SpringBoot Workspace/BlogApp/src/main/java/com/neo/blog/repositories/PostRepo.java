package com.neo.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.blog.entities.Category;
import com.neo.blog.entities.Post;
import com.neo.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
}
