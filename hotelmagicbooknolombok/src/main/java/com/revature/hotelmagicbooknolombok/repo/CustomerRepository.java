/**
 * Repository Interface for the p2_customers table
 */
package com.revature.hotelmagicbooknolombok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbooknolombok.model.Customer;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
