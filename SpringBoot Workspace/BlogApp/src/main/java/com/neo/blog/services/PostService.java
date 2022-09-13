package com.neo.blog.services;

import java.util.List;


import com.neo.blog.entities.Post;
import com.neo.blog.payloads.PostDto;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//getAll
	List<Post> getAllPost();
	
	//getSingle
	PostDto getPostById(Integer postId);
	
	
	//getAllPostByCategory
	 List<Post> getAllPostByCategory(Integer categoryId);
	 
	 //getAllPostByUser
	 List<Post> getAllPostByUser(Integer userId);
		 
	 //search post
	 List<Post> searchPost(String keyword);
		 
		 
		 
	 
	 
	
	
}
