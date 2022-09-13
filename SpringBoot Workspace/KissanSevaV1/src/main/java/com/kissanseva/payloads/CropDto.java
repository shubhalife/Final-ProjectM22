package com.kissanseva.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CropDto {
	
	
    private int cropId;
	
    @NotEmpty
	@Size(min= 3, max = 20 , message ="max 10"  )
	private String cropName;
	
    
	private double msp;

}
