/**
 * Controller class for p2_customers table
 */
package com.revature.hotelmagicbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hotelmagicbook.model.Customer;
import com.revature.hotelmagicbook.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		log.info("Getting all the records in the Customers database.");
		return customerService.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.findByCustomerId(id);
	}

	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
	}

	@PutMapping("/customers/{id}")
	public void editCustomer(@PathVariable int id, @RequestBody Customer customer) {
		customerService.save(customer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		customerService.delete(id);
	}
}
