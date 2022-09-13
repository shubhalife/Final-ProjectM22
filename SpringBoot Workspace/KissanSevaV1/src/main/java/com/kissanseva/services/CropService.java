package com.kissanseva.services;

import java.util.List;

import com.kissanseva.payloads.CropDto;



public interface CropService {
	//create
		 CropDto createCrop(CropDto cropDto);
		
		 //update
		 CropDto updateCrop(CropDto cropDto, Integer cropId);
		
		 //delete
		 void deleteCrop(Integer cropId);
		
		 //get
		 CropDto getCrop(Integer cropId);
		
		//getAll
		List<CropDto> getCrops();

}
