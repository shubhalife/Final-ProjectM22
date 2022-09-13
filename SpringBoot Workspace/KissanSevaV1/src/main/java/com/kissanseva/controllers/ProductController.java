package com.kissanseva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kissanseva.payloads.ProductDto;
import com.kissanseva.services.ProductService;


@RestController
@RequestMapping("/api/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	    //post - create post
		@PostMapping("/user/{userId}/crop/{cropId}/product")
		public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable Integer userId,@PathVariable Integer cropId){
			
			ProductDto createProduct = this.productService.createProduct(productDto, userId, cropId);
			
			return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
		}

}
