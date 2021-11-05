/**
 * Controller class for p2_reservations
 */
package com.revature.hotelmagicbooknolombok.controller;

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

import com.revature.hotelmagicbooknolombok.model.Reservation;
import com.revature.hotelmagicbooknolombok.service.ReservationService;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@GetMapping("/reservations")
	public List<Reservation> getRooms() {
		return reservationService.findAll();
	}

	@GetMapping("/reservations/{id}")
	public Reservation getRoomById(@PathVariable int id) {
		return reservationService.findByReservationId(id);
	}
	
	@GetMapping("/reservations/searchByCustomer/{customerId}")
	public List<Reservation> getRoomsBySize(@PathVariable int customerId) {
		return reservationService.findReservationsByCustomerId(customerId);
	}
	
	@GetMapping("/reservations/searchPaidFor/{paidFor}")
	public List<Reservation> getRoomsWithSmoke(@PathVariable boolean paidFor) {
		return reservationService.findReservationsByPaidFor(paidFor);
	}
	
	@GetMapping("/reservations/searchByRoom/{roomId}")
	public List<Reservation> getRoomsByRoomSizeAndIsSmoking(@PathVariable int roomId) {
		return reservationService.findReservationsByRoomId(roomId);
	}
	
	@GetMapping("/reservations/reserved")
	public boolean isRoomReserved(@RequestBody int roomId, @RequestBody Date startDate, @RequestBody Date endDate) throws Exception {
		return reservationService.findIfRoomBooked(roomId, startDate, endDate);
	}

	@PostMapping("/reservations")
	public void saveRoom(@RequestBody Reservation reservation) {
		reservationService.save(reservation);
	}

	@PutMapping("/reservations/{id}")
	public void editRoom(@PathVariable int id, @RequestBody Reservation reservation) {
		reservationService.save(reservation);
	}

	@DeleteMapping("/reservations/{id}")
	public void deleteRoomById(@PathVariable int id) {
		reservationService.delete(id);
	}
}
