/**
 * Controller class for the p2_payment table
 */
package com.revature.hotelmagicbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hotelmagicbook.model.Payment;
import com.revature.hotelmagicbook.service.PaymentService;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/payments")
	public List<Payment> getPayments() {
		return paymentService.findAll();
	}

	@GetMapping("/payments/{id}")
	public Payment getPaymentById(@PathVariable long id) {
		return paymentService.findById(id);
	}

	@PostMapping("/payments")
	public void savePayment(@RequestBody Payment payment) {
		paymentService.save(payment);
	}

	@PutMapping("/payments/{id}")
	public void editPayment(@PathVariable long id, @RequestBody Payment payment) {
		paymentService.save(payment);
	}

	@DeleteMapping("/payments/{id}")
	public void deletePaymentById(@PathVariable long id) {
		paymentService.delete(id);
	}
}
