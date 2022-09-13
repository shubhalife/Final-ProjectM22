package com.kissanseva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kissanseva.entities.Crop;

public interface CropRepo  extends JpaRepository<Crop, Integer>{

}
