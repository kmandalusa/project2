/**
 * Service Interface for the p2_payment table
 */
package com.revature.hotelmagicbook.service;

import java.util.List;

import com.revature.hotelmagicbook.model.Payment;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface PaymentService {
	
	List<Payment> findAll();
	
	Payment findById(long id);
	
	void save(Payment payment);
	
	void update(long id, Payment payment);
	
	void delete(long id);

}
