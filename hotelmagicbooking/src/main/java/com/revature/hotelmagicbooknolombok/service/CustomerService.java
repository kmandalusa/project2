/**
 * Service interface for the p2_customers table
 */
package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import com.revature.hotelmagicbooknolombok.model.Customer;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface CustomerService {
	
	List<Customer> findAll();
	
	Customer findByCustomerId(int id);
	
	void save(Customer customer);
	
	void update(int id, Customer customer);
	
	void delete(int id);

}