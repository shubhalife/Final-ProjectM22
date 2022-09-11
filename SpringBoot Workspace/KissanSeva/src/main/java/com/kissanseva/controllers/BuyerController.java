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
import com.kissanseva.payloads.BuyerDto;
import com.kissanseva.services.BuyerService;


@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

	
	@Autowired
	private BuyerService buyerService;
	
	
	
	//post - create user
			@PostMapping("/")
			public ResponseEntity<BuyerDto> createUser(@RequestBody BuyerDto buyerDto){
				//System.out.println("control here......");
				BuyerDto createBuyerDto=this.buyerService.createBuyer(buyerDto);
				
				return new ResponseEntity<>(createBuyerDto,HttpStatus.CREATED);
			}
			
			//put - update user
			@PutMapping("/{buyerId}")
			public ResponseEntity<BuyerDto>updateUser(@RequestBody BuyerDto buyerDto, @PathVariable Integer buyerId){
				BuyerDto updatedBuyerDto = this.buyerService.updateBuyer(buyerDto, buyerId);
				
				return ResponseEntity.ok(updatedBuyerDto);
				
			}
			
			
			//delete - delete user
			@DeleteMapping("/{buyerId}")
			public ResponseEntity<ApiResponse>deleteBuyer(@PathVariable Integer buyerId){
				
				this.buyerService.deleteBuyer(buyerId);
				
				//return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
				return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true), HttpStatus.OK);
			}
			
			
			//GET - all user
			@GetMapping("/")
			public ResponseEntity<List<BuyerDto>> getAllUsers(){
				
				return ResponseEntity.ok(this.buyerService.getAllBuyer());
			}
			
			//GET - single user 
			@GetMapping("/{buyerId}")
			public ResponseEntity<BuyerDto> getSingleUser(@PathVariable Integer buyerId){
				
				return ResponseEntity.ok(this.buyerService.getBuyerById(buyerId));
			}
			
			
}
