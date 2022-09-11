package com.neo.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
