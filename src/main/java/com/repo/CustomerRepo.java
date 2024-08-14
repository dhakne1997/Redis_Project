package com.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Customer; 

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer> { 
	
	
} 
