package com.kissanseva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buyers")
@NoArgsConstructor                       // no argrument constructor by lombok
@Getter                                 //lombok create getter setter for us
@Setter
public class Buyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buyerId;
	
	private String  firstName;
	
	private String lastName;
	
	private String adhaarId;
	
	private String email;
	
	private String password;
	
	private String mobileNo;
	
	@Column(columnDefinition = "varchar(200)")
	private String address;
	
	private String taluka;

}
