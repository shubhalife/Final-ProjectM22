package com.kissanseva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kissanseva.entities.Crop;
import com.kissanseva.entities.Product;
import com.kissanseva.entities.User;
;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	List<Product> findByUser(User user);
	List<Product> findByCrop(Crop crop);

}
