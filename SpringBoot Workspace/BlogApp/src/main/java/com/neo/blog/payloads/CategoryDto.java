package com.neo.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotEmpty
	@Size(min= 4, max = 10 , message ="max 10"  )
	private String categoryTitle;
	
	@NotEmpty
	private String categoryDescription;

}
