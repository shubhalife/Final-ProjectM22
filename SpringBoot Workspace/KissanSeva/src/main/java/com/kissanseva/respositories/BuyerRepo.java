package com.kissanseva.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kissanseva.entities.Buyer;



public interface BuyerRepo extends JpaRepository<Buyer, Integer>{

}
