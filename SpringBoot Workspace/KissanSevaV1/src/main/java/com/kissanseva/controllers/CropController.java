package com.kissanseva.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kissanseva.payloads.ApiResponse;
import com.kissanseva.payloads.CropDto;
import com.kissanseva.services.CropService;





@RestController
@RequestMapping("/api/crop")
public class CropController {
	
	@Autowired
	private CropService cropService;
	
	
	    //create
		@PostMapping("/")
		public ResponseEntity<CropDto> createCrop(@Valid @RequestBody CropDto cropDto){
			CropDto createCrop = this.cropService.createCrop(cropDto);
			return new ResponseEntity<CropDto>(createCrop,HttpStatus.CREATED);
			
		}
		
		//update
		
		@PutMapping("/{cropId}")
		public ResponseEntity<CropDto> updateCrop(@Valid @RequestBody CropDto cropDto ,@PathVariable Integer cropId){
			CropDto updatedCrop = this.cropService.updateCrop(cropDto, cropId);
			return new ResponseEntity<CropDto>(updatedCrop,HttpStatus.OK);
			
		}
		
		
		//delete
		@DeleteMapping("/{cropId}")
		public ResponseEntity<ApiResponse> deleteCrop(@PathVariable Integer cropId){
		    this.cropService.deleteCrop(cropId);
		    return new ResponseEntity<ApiResponse>(new ApiResponse("crop deleted successfully",true), HttpStatus.OK);
			
		}
		
		
		//getAll
		@GetMapping("/")
		public ResponseEntity<List<CropDto>> getAllCrop(){
			
			return ResponseEntity.ok(this.cropService.getCrops());
		}
		
		
		//getSingle
		@GetMapping("/{cropId}")
		public ResponseEntity<CropDto> getSingleCrop(@PathVariable Integer cropId){
			
			return ResponseEntity.ok(this.cropService.getCrop(cropId));
		}

}
