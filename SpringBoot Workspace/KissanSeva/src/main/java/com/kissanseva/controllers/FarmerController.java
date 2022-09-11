package com.kissanseva.controllers;

import java.util.List;

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
import com.kissanseva.payloads.FarmerDto;
import com.kissanseva.services.FarmerService;





@RestController
@RequestMapping("/api/farmer")
public class FarmerController {
	
	
	@Autowired
	private FarmerService farmerService;
	
	//post - create user
		@PostMapping("/")
		public ResponseEntity<FarmerDto> createUser(@RequestBody FarmerDto farmerDto){
			//System.out.println("control here......");
			FarmerDto createFarmerDto=this.farmerService.createFarmer(farmerDto);
			
			return new ResponseEntity<>(createFarmerDto,HttpStatus.CREATED);
		}
		
		//put - update user
		@PutMapping("/{farmerId}")
		public ResponseEntity<FarmerDto>updateUser(@RequestBody FarmerDto farmerDto, @PathVariable Integer farmerId){
			FarmerDto updatedFarmerDto = this.farmerService.updateFarmer(farmerDto, farmerId);
			
			return ResponseEntity.ok(updatedFarmerDto);
			
		}
		
		
		//delete - delete user
		@DeleteMapping("/{farmerId}")
		public ResponseEntity<ApiResponse>deleteFarmer(@PathVariable Integer farmerId){
			
			this.farmerService.deleteFarmer(farmerId);
			
			//return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
			return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true), HttpStatus.OK);
		}
		
		
		//GET - all user
		@GetMapping("/")
		public ResponseEntity<List<FarmerDto>> getAllUsers(){
			
			return ResponseEntity.ok(this.farmerService.getAllFarmer());
		}
		
		//GET - single user 
		@GetMapping("/{farmerId}")
		public ResponseEntity<FarmerDto> getSingleUser(@PathVariable Integer farmerId){
			
			return ResponseEntity.ok(this.farmerService.getFarmerById(farmerId));
		}

	

}
