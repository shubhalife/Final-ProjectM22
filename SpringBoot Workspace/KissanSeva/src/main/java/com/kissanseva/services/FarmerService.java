package com.kissanseva.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kissanseva.payloads.FarmerDto;


@Service
public interface FarmerService {
	
	FarmerDto createFarmer(FarmerDto farmerDto);
	FarmerDto updateFarmer(FarmerDto farmerDto,Integer farmerId);
	FarmerDto getFarmerById(Integer farmerId);
	List<FarmerDto> getAllFarmer();
	void deleteFarmer(Integer farmerId);

}
