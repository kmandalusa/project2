/**
 * Controller class for p2_reservations
 */
package com.revature.hotelmagicbook.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hotelmagicbook.model.Reservation;
import com.revature.hotelmagicbook.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
@Slf4j
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@GetMapping("/reservations")
	public List<Reservation> getReservations() {
		log.info("Getting all the records in the Reservations database.");
		return reservationService.findAll();
	}

	@GetMapping("/reservations/{id}")
	public Reservation getReservationById(@PathVariable int id) {
		return reservationService.findByReservationId(id);
	}
	
	@GetMapping("/reservations/searchByCustomer/{customerId}")
	public List<Reservation> getReservationsByCustomer(@PathVariable int customerId) {
		return reservationService.findReservationsByCustomerId(customerId);
	}
	
	@GetMapping("/reservations/searchPaidFor/{paidFor}")
	public List<Reservation> getReservationsPaidFor(@PathVariable boolean paidFor) {
		return reservationService.findReservationsByPaidFor(paidFor);
	}
	
	@GetMapping("/reservations/searchByRoom/{roomId}")
	public List<Reservation> getReservationsByType(@PathVariable int roomId) {
		return reservationService.findReservationsByRoomId(roomId);
	}
	
	@GetMapping("/reservations/reserved")
	public boolean isRoomReserved(@RequestBody int roomId, @RequestBody Date startDate, @RequestBody Date endDate) throws Exception {
		return reservationService.findIfRoomBooked(roomId, startDate, endDate);
	}

	@PostMapping("/reservations")
	public void saveReservation(@RequestBody Reservation reservation) {
		reservationService.save(reservation);
	}

	@PutMapping("/reservations/{id}")
	public void editReservation(@PathVariable int id, @RequestBody Reservation reservation) {
		reservationService.save(reservation);
	}

	@DeleteMapping("/reservations/{id}")
	public void deleteReservationById(@PathVariable int id) {
		reservationService.delete(id);
	}
}
