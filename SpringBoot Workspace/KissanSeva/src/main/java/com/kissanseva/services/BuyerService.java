package com.kissanseva.services;

import java.util.List;

import com.kissanseva.payloads.BuyerDto;


public interface BuyerService {
	BuyerDto createBuyer(BuyerDto buyerDto);
	BuyerDto updateBuyer(BuyerDto buyerDto,Integer buyerId);
	BuyerDto getBuyerById(Integer buyerId);
	List<BuyerDto> getAllBuyer();
	void deleteBuyer(Integer buyerId);

}
