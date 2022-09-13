package com.kissanseva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kissanseva.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
