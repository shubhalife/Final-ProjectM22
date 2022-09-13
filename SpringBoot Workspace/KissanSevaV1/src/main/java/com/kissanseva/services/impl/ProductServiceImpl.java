package com.kissanseva.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kissanseva.entities.Crop;
import com.kissanseva.entities.Product;
import com.kissanseva.entities.User;
import com.kissanseva.exceptions.ResourceNotFoundException;
import com.kissanseva.payloads.ProductDto;
import com.kissanseva.repositories.CropRepo;
import com.kissanseva.repositories.ProductRepo;
import com.kissanseva.repositories.UserRepo;
import com.kissanseva.services.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo; 
	
	@Autowired
	private CropRepo cropRepo;
	
	

	@Override
	public ProductDto createProduct(ProductDto productDto, Integer userId, Integer cropId) {
		Crop crop = this.cropRepo.findById(cropId).orElseThrow(()-> new ResourceNotFoundException("Crop", "Crop Id", cropId));
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		Product product = this.modelMapper.map(productDto, Product.class);
		product.setAddDate(new Date());
		product.setUser(user);
		product.setCrop(crop);
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		
		Product savedProduct = this.productRepo.save(product);
		
		return this.modelMapper.map(savedProduct, ProductDto.class);
	}

	
	
	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer productId) {
		Product product =  this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "product Id", productId));
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		
		Product updatedProduct =  this.productRepo.save(product);
		return this.modelMapper.map(updatedProduct, ProductDto.class);
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product product =  this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "product Id", productId));
		
		this.productRepo.delete(product);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products = this.productRepo.findAll();
		 List<ProductDto> productDtos = products.stream().map((product)->this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
		
		return productDtos;
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		Product product =  this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "product Id", productId));
		
		return this.modelMapper.map(product,ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProductByCrop(Integer cropId) {
		Crop crop = this.cropRepo.findById(cropId).orElseThrow(()-> new ResourceNotFoundException("Crop", "Crop Id", cropId));
		
		List<Product> products=	this.productRepo.findByCrop(crop);
		
		 List<ProductDto> productDtos = products.stream().map((product)->this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
		
		return productDtos;
	}

	@Override
	public List<ProductDto> getAllProductByUser(Integer userId) {
		User user=	this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		List<Product> products=	this.productRepo.findByUser(user);
		
		List<ProductDto> productDtos = products.stream().map((product)->this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
		
		return productDtos;
	}

}
