/**
 * Controller class for p2_customers table
 */
package com.revature.hotelmagicbooknolombok.controller;

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

import com.revature.hotelmagicbooknolombok.model.Customer;
import com.revature.hotelmagicbooknolombok.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dipanjali Ghosh & Krishna Mandal
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.findByCustomerId(id);
	}

	@GetMapping("/customers/searchByEmail/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return customerService.findByEmail(email);
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

	@PostMapping("/login")
	public Customer loginCustomer(@RequestBody Customer customer) {
		Customer myCustomer = customerService.findByEmail(customer.getEmail());
		log.info("Attempting to log in.");
		
		if(myCustomer == null)
		{
			log.info("Email not registered.");
			return null;
		}
		else
		{
			log.info("Valid email.");
			if(customer.getPassword().compareTo(myCustomer.getPassword()) != 0)
			{
				log.info("Invalid email or password.");
				return null;
			}
			else
			{
				log.info("Valid login. Welcome " + myCustomer.getName());
				return myCustomer;
			}
		}
		/*
		 * app.post("/login", ctx -> { String name = ctx.formParam("userId");
		 * logger.info("User trying to login with userId: "+name);
		 * logger.debug(" User trying to login with userId: "+name); employee =
		 * EmployeeDAO.findById(name); if (Objects.isNull(employee)) {
		 * ctx.redirect("error1.html"); // When employee/manager userId wrong } else {
		 * String password = ctx.formParam("password");
		 * logger.info("User trying to login with password: "+password); if
		 * (employee.isPasswordMatch(password)) { if
		 * (employee.getRole().equalsIgnoreCase("manager")) {
		 * ctx.redirect("manager.html"); // When user is manager } else {
		 * ctx.redirect("employee.html"); // when user is employee } } else {
		 * 
		 * ctx.redirect("error2.html"); // In case of wrong password }
		 * logger.info("userId: " + name + " password: " + password); }
		 * 
		 * });
		 */
	}
}
