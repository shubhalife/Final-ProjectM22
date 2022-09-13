package com.kissanseva.services;

import java.util.List;

import com.kissanseva.entities.Product;
import com.kissanseva.payloads.ProductDto;



public interface ProductService {
	
	    //create
		ProductDto createProduct(ProductDto productDto, Integer userId, Integer cropId);
		
		//update
		ProductDto updateProduct(ProductDto productDto, Integer productId);
		
		//delete
		void deleteProduct(Integer productId);
		
		//getAll
		List<Product> getAllProduct();
		
		//getSingle
		ProductDto getProductById(Integer productId);
		
		
		//getAllPostByCategory
		 List<Product> getAllProductByCrop(Integer cropId);
		 
		 //getAllPostByUser
		 List<Product> getAllProductByUser(Integer userId);
			 
		 //search post
		//List<Product> searchPost(String keyword);

}
