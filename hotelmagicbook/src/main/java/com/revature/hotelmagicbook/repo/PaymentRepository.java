/**
 * Repository class for the p2_payment table
 */
package com.revature.hotelmagicbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbook.model.Payment;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
