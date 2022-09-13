package com.neo.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	
	
}
