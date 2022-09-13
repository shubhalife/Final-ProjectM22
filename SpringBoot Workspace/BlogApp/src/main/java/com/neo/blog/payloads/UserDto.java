package com.neo.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
    private int id;
	
    
    @NotEmpty
    @Size(min=4, message= "Username must be min 4 characters")
	private String name;
	
    @Email(message = "Email is not valid")
    @NotEmpty
	private String email;
    
	
	@NotEmpty
	@Size(min=3, max=10, message=" password must be minimum 3 char and max 10")
	private String password;
	
	
	@NotEmpty
	private String about;
	

}
