package com.kissanseva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kissanseva.entities.Product;
import com.kissanseva.payloads.ApiResponse;
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
		
		
		//get by user
		@GetMapping("/user/{userId}/product")
		public ResponseEntity<List<ProductDto>> getProductByUser(@PathVariable Integer userId){
			
			List<ProductDto> productDtos = this.productService.getAllProductByUser(userId);
			
			return new ResponseEntity<List<ProductDto>>(productDtos,HttpStatus.OK);
		}
		
		//get by user
		@GetMapping("/crop/{cropId}/product")
		public ResponseEntity<List<ProductDto>> getProductByCrop(@PathVariable Integer cropId){
					
			List<ProductDto> productDtos = this.productService.getAllProductByCrop(cropId);
					
			return new ResponseEntity<List<ProductDto>>(productDtos,HttpStatus.OK);
		}
		
		
		//getAllProducts
		@GetMapping("/product")
		public ResponseEntity<List<ProductDto>> getAllProduct(){
			List<ProductDto> productDtos = this.productService.getAllProduct();
			
			return new ResponseEntity<List<ProductDto>>(productDtos,HttpStatus.OK);
			
		}
		
		
		//get Product By Id
		@GetMapping("/product/{productId}")
		public ResponseEntity<ProductDto> getProductById(@PathVariable Integer productId){
		ProductDto productDto	=this.productService.getProductById(productId);
			
		return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
		}
		
		//delete
		@DeleteMapping("/product/{productId}")
		public ResponseEntity<ApiResponse>deleteProduct(@PathVariable Integer productId){
			
		this.productService.deleteProduct(productId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("product deleted successfully",true), HttpStatus.OK);
			
		}
		
		
		//update
		@PutMapping("/product/{productId}")
		public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable Integer productId){
		ProductDto updatedProduct =	this.productService.updateProduct(productDto, productId);
		return new ResponseEntity<ProductDto>(updatedProduct,HttpStatus.OK);
		}
		
		

}
