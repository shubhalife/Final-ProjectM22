package com.kissanseva.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kissanseva.entities.Farmer;
import com.kissanseva.exceptions.ResourceNotFoundException;
import com.kissanseva.payloads.FarmerDto;
import com.kissanseva.respositories.FarmerRepo;
import com.kissanseva.services.FarmerService;



@Service
public class FarmerServiceImpl implements FarmerService {
	
	@Autowired
	private FarmerRepo farmerRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FarmerDto createFarmer(FarmerDto farmerDto) {
		Farmer farmer = this.dtoToFarmer(farmerDto);
		Farmer savedFarmer = this.farmerRepo.save(farmer);
		return this.farmerToDto(savedFarmer);
		
	}

	@Override
	public FarmerDto updateFarmer(FarmerDto farmerDto, Integer farmerId) {
		Farmer farmer = this.farmerRepo.findById(farmerId).orElseThrow(()-> new ResourceNotFoundException("User","Id",farmerId));
		
		farmer.setFirstName(farmerDto.getFirstName());
		farmer.setLastName(farmerDto.getLastName());
		farmer.setEmail(farmerDto.getEmail());
		farmer.setPassword(farmerDto.getPassword());
		farmer.setAdhaarId(farmerDto.getAdhaarId());
		farmer.setMobileNo(farmerDto.getMobileNo());
		farmer.setTaluka(farmerDto.getTaluka());
		farmer.setAddress(farmerDto.getAddress());
		
        Farmer updatedFarmer = this.farmerRepo.save(farmer);
		
		return this.farmerToDto(updatedFarmer);
		
		
	}

	@Override
	public FarmerDto getFarmerById(Integer farmerId) {
		
		Farmer farmer = this.farmerRepo.findById(farmerId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", farmerId));
		
		return this.farmerToDto(farmer);
	}

	@Override
	public List<FarmerDto> getAllFarmer() {
        List<Farmer> farmers =this.farmerRepo.findAll();
		
	    List<FarmerDto> farmerDtos =farmers.stream().map(farmer-> this.farmerToDto(farmer)).collect(Collectors.toList());
		
		return farmerDtos;
	}

	@Override
	public void deleteFarmer(Integer farmerId) {
		 Farmer farmer=	this.farmerRepo.findById(farmerId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", farmerId));
			this.farmerRepo.delete(farmer);

	}
	
	private Farmer dtoToFarmer(FarmerDto farmerDto) {
		Farmer farmer = this.modelMapper.map(farmerDto, Farmer.class);
		
		return farmer;
	}
	
	private FarmerDto farmerToDto(Farmer farmer) {
		FarmerDto farmerDto = this.modelMapper.map(farmer, FarmerDto.class);
		
		return farmerDto;
	}

}
