package com.kissanseva.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kissanseva.entities.Buyer;

import com.kissanseva.exceptions.ResourceNotFoundException;
import com.kissanseva.payloads.BuyerDto;

import com.kissanseva.respositories.BuyerRepo;
import com.kissanseva.services.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	private BuyerRepo buyerRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuyerDto createBuyer(BuyerDto buyerDto) {
		Buyer buyer = this.dtoToBuyer(buyerDto);
		Buyer savedBuyer = this.buyerRepo.save(buyer);
		return this.buyerToDto(savedBuyer);
	}

	@Override
	public BuyerDto updateBuyer(BuyerDto buyerDto, Integer buyerId) {
		Buyer buyer = this.buyerRepo.findById(buyerId).orElseThrow(()-> new ResourceNotFoundException("User","Id",buyerId));
		
		buyer.setFirstName(buyerDto.getFirstName());
		buyer.setLastName(buyerDto.getLastName());
		buyer.setEmail(buyerDto.getEmail());
		buyer.setPassword(buyerDto.getPassword());
		buyer.setAdhaarId(buyerDto.getAdhaarId());
		buyer.setMobileNo(buyerDto.getMobileNo());
		buyer.setTaluka(buyerDto.getTaluka());
		buyer.setAddress(buyerDto.getAddress());
		
		Buyer updatedBuyer = this.buyerRepo.save(buyer);
		
		return this.buyerToDto(updatedBuyer);
	}

	@Override
	public BuyerDto getBuyerById(Integer buyerId) {
		Buyer buyer = this.buyerRepo.findById(buyerId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", buyerId));
		
		return this.buyerToDto(buyer);
	}

	@Override
	public List<BuyerDto> getAllBuyer() {
		List<Buyer> buyers =this.buyerRepo.findAll();
		
	    List<BuyerDto> buyerDtos =buyers.stream().map(buyer-> this.buyerToDto(buyer)).collect(Collectors.toList());
		
		return buyerDtos;
	}

	@Override
	public void deleteBuyer(Integer buyerId) {
		Buyer buyer=	this.buyerRepo.findById(buyerId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", buyerId));
		this.buyerRepo.delete(buyer);

	}
	
	
	private Buyer dtoToBuyer(BuyerDto buyerDto) {
		Buyer buyer = this.modelMapper.map(buyerDto, Buyer.class);
		
		return buyer;
	}
	
	private BuyerDto buyerToDto(Buyer buyer) {
		BuyerDto buyerDto = this.modelMapper.map(buyer, BuyerDto.class);
		
		return buyerDto;
	}

}
