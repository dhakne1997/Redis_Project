package com.service;


import java.util.ArrayList; 
import java.util.List; 
import java.util.Optional; 
import lombok.RequiredArgsConstructor; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.Entity.Customer;
import com.repo.CustomerRepo; 

@Service
public class CustomerService { 

	@Autowired
	private CustomerRepo repo; 

	public Customer addCustomer(Customer customer){ 

		return repo.save(customer); 
	} 

	public List<Customer> getAllCustomers(){ 

		List<Customer> allCustomer = new ArrayList<>(); 
		repo.findAll().forEach(allCustomer::add); 
		return allCustomer; 
	} 

	public Customer getCustomerById(int id){ 

		Optional<Customer> optionalCustomer 
			= repo.findById(id); 
		return optionalCustomer.orElse(null); 
	} 

		
	public Customer updateCustomerById(int id, 
									Customer newCustomer){ 
		
		Optional<Customer> existingCustomer 
			= repo.findById(id); 

		if (existingCustomer.isPresent()) { 
			Customer updatedCustomer 
				= existingCustomer.get(); 

			updatedCustomer.setName(newCustomer.getName()); 
			updatedCustomer.setPhone(newCustomer.getPhone()); 
			updatedCustomer.setEmail(newCustomer.getEmail()); 

			repo.deleteById(id); 
			return repo.save(updatedCustomer); 
		} 

		return null; 
	} 

	public void deleteCustomerById(int id){ 
		repo.deleteById(id); 
	} 
}

