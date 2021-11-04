/**
 * Implementation for the PaymentService interface
 */
package com.revature.hotelmagicbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbook.model.Payment;
import com.revature.hotelmagicbook.repo.PaymentRepository;

/**
 * @author Dipanjali Ghosh
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment findById(long id) {
		return paymentRepository.getById(id);
	}

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public void update(long id, Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public void delete(long id) {
		paymentRepository.deleteById(id);
	}

}
