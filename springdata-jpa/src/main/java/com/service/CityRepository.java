package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.model.City;

public interface CityRepository extends CrudRepository<City,Long> {

	public City save(City city);
	
	public City findByNameAndPincode(String name,String pin);
	
	Page<City> findAll(Pageable pageable);
	
	 @Query("from City where name=?1")
	 List<City> findAllCityByName(String name);
	
}
