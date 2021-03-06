/**
 * Repository Interface for the p2_customers table
 */
package com.revature.hotelmagicbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbook.model.Customer;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerId(int id);
}
