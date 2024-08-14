package com.controller;


import java.util.ArrayList; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import com.Entity.Customer;
import com.service.CustomerService; 

@RestController
@RequestMapping("/customer") 
public class CustomerController { 

	@Autowired
	private CustomerService service; 

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer){ 

		return service.addCustomer(customer); 
	} 

	@GetMapping
	public List<Customer> getListOfCustomers(){ 
	
		return service.getAllCustomers(); 
	} 

	@GetMapping("/{id}") 
	public Customer getCustomer(@PathVariable int id){ 
		
		return service.getCustomerById(id); 
	} 

	@PutMapping("/{id}") 
	public Customer 
	updateCustomer(@PathVariable int id, 
				@RequestBody Customer newCustomer){ 
		
		return service.updateCustomerById(id, newCustomer); 
	} 

	@DeleteMapping("/{id}") 
	public String deleteCustomer(@PathVariable int id){ 
		
		service.deleteCustomerById(id); 
		return "Customer Deleted Successfully"; 
	} 
}

