package com.kissanseva.payloads;





import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProductDto {
	
	private int productId;
	
	
    private double quantity;
	
	
	private double price;
	
	
	private Date addDate;
	
	
	private UserDto user;
	
	
	private CropDto crop;

}
