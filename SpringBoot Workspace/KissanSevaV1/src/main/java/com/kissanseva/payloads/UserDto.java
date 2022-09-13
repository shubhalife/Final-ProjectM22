package com.kissanseva.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int userId;
	
	
	@NotEmpty
	@Size(min=4, message= "Username must be min 4 characters")
    private String  firstName;
	
	@NotEmpty
	private String lastName;
	 
	@NotEmpty
	private String adhaarId;
	
	@NotEmpty
	@Email(message = "Email is not valid")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message=" password must be minimum 3 char and max 10")
	private String password;
	
	@NotEmpty
	@Size(max=10, message="Please Enter 10 digit mobile Number")
	private String mobileNo;
	 
	@NotEmpty
    private String address;
	
	@NotEmpty
	private String taluka;

}
