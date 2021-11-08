/**
 * Repository Interface for the p2_customers table
 */
package com.revature.hotelmagicbooknolombok.repo;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbooknolombok.model.Customer;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerId(int id);
	public Customer findByEmail(String email);
}
