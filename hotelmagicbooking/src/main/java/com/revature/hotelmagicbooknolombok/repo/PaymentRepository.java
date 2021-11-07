/**
 * Repository class for the p2_payment table
 */
package com.revature.hotelmagicbooknolombok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbooknolombok.model.Payment;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
