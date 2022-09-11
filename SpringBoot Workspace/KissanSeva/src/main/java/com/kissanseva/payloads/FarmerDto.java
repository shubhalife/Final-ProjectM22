package com.kissanseva.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor                       // no argrument constructor by lombok
@Getter                                 //lombok create getter setter for us
@Setter
public class FarmerDto {
	
    private int farmerId;
	
	private String  firstName;
	
	private String lastName;
	
	private String adhaarId;
	
	private String email;
	
	private String password;
	
	private String mobileNo;
	
	private String address;
	
	private String taluka;
	

}
