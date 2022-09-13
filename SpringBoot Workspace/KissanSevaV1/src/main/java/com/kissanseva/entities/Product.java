package com.kissanseva.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	
	private double quantity;
	
	
	private double price;
	
	private Date addDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Crop crop;
	
	
	
	
	
	
	
	

}
