package com.kissanseva.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kissanseva.entities.Farmer;



public interface FarmerRepo extends JpaRepository<Farmer, Integer>{
	

}
