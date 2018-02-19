package com.gabor.usermanagment.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabor.usermanagment.beans.Customer;
import com.gabor.usermanagment.dao.CustomerDao;

@RestController
@RequestMapping("/api")
public class customerAPI {

	public static final Logger logger = LoggerFactory.getLogger(customerAPI.class);

	@Autowired
	CustomerDao customerDao;

	@GetMapping("/getAll")
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();
	}
	@PostMapping("/createCustomer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerDao.save(customer);
	}
	
	@GetMapping("/getCustomerbyID/{customerID}")
	public ResponseEntity<Customer> getNoteById(@PathVariable(value = "customerID") Long customerID) {
	    Customer customer = customerDao.findOne(customerID);
	    if(customer == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(customer);
	}
	@PutMapping("/updateCustomer/{customerID}")
	public ResponseEntity<Customer> updateNote(@PathVariable(value = "customerID") Long customerID, 
	                                       @Valid @RequestBody Customer customerdetails) {
	    Customer customer = customerDao.findOne(customerID);
	    if(customer == null) {
	        return ResponseEntity.notFound().build();
	    }
	    customer.setCustomerAddress(customerdetails.getCustomerAddress());
	    customer.setCustomerName(customerdetails.getCustomerName());
	    customer.setCustomerPhoneNumber(customerdetails.getCustomerPhoneNumber());
	    
	    Customer updatedNote = customerDao.save(customer);
	    return ResponseEntity.ok(updatedNote);
	}
	
	@DeleteMapping("/deleteCustomer/{customerID}")
	public ResponseEntity<Customer> deleteNote(@PathVariable(value = "customerID") Long customerID) {
	    Customer customer = customerDao.findOne(customerID);
	    if(customer == null) {
	        return ResponseEntity.notFound().build();
	    }

	    customerDao.delete(customerID);
	    return ResponseEntity.ok().build();
	}
		
	}
	








