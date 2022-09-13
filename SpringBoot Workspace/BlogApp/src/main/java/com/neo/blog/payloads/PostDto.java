package com.neo.blog.payloads;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.neo.blog.entities.Category;
import com.neo.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class PostDto {
	
	
	@NotEmpty
	private String title;

	@NotEmpty
    private String content;
	

    private String imageName;
	
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;

	
}
