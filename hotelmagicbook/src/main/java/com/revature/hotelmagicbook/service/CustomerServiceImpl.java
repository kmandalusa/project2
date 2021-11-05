/**
 * Implementation of the CustomerService interface
 */
package com.revature.hotelmagicbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbook.model.Customer;
import com.revature.hotelmagicbook.repo.CustomerRepository;

/**
 * @author Dipanjali Ghosh
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
		return customerRepository.getById(id);
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void update(int id, Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void delete(int id) {
		customerRepository.deleteById(id);
	}

}
