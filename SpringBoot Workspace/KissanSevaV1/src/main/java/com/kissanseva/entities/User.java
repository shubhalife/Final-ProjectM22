package com.kissanseva.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor                       
@Getter                                 
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String  firstName;
	
	private String lastName;
	
	private String adhaarId;
	
	private String email;
	
	private String password;
	
	private String mobileNo;
	
	@Column(columnDefinition = "varchar(200)")
	private String address;
	
	private String taluka;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch =FetchType.LAZY )
	private List<Product> products = new ArrayList<>();

}
