/**
 * Implementation of the CustomerService interface
 */
package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbooknolombok.model.Customer;
import com.revature.hotelmagicbooknolombok.repo.CustomerRepository;

/**
 * @author Dipanjali Ghosh & Krishna Mandal
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findByCustomerId(int id) {
		return customerRepository.findByCustomerId(id);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void update(int id, Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void delete(int id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

}
