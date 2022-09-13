package com.kissanseva.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kissanseva.entities.Crop;
import com.kissanseva.exceptions.ResourceNotFoundException;
import com.kissanseva.payloads.CropDto;
import com.kissanseva.repositories.CropRepo;
import com.kissanseva.services.CropService;


@Service
public class CropServiceImpl implements CropService{

	@Autowired
	private CropRepo cropRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CropDto createCrop(CropDto cropDto) {
		Crop crop= this.modelMapper.map(cropDto, Crop.class);
		
		Crop addedCrop= this.cropRepo.save(crop);
		return this.modelMapper.map(addedCrop, CropDto.class);
	}
	
	

	@Override
	public CropDto updateCrop(CropDto cropDto, Integer cropId) {
		Crop crop = this.cropRepo.findById(cropId).orElseThrow(()-> new ResourceNotFoundException("Crop", "Crop Id", cropId));
		
		crop.setCropName(cropDto.getCropName());
		crop.setMsp(cropDto.getMsp());
		
		Crop updatedCrop = this.cropRepo.save(crop);
		return this.modelMapper.map(updatedCrop, CropDto.class);
	}
	
	

	@Override
	public void deleteCrop(Integer cropId) {
		Crop crop = this.cropRepo.findById(cropId).orElseThrow(()-> new ResourceNotFoundException("Crop", "Crop Id", cropId));
		this.cropRepo.delete(crop);
		
	}

	@Override
	public CropDto getCrop(Integer cropId) {
		Crop crop = this.cropRepo.findById(cropId).orElseThrow(()-> new ResourceNotFoundException("Crop", "Crop Id", cropId));
		
		return this.modelMapper.map(crop, CropDto.class);
		
		
	}

	@Override
	public List<CropDto> getCrops() {
		List<Crop> crops =this.cropRepo.findAll();
		List<CropDto> cropDtos =crops.stream().map(crop-> this.modelMapper.map(crop, CropDto.class)).collect(Collectors.toList());
			
			return cropDtos;
	}

}
