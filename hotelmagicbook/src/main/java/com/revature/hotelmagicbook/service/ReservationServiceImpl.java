/**
 * Implementing the ReservationService Interface
 */
package com.revature.hotelmagicbook.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbook.model.Reservation;
import com.revature.hotelmagicbook.repo.ReservationRepository;

/**
 * @author Dipanjali Ghosh
 *
 */
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(int id) {
		return reservationRepository.getById(id);
	}

	@Override
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	public void update(int id, Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	public void delete(int id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public List<Reservation> findReservationsByCustomer(int customerId) {
		return reservationRepository.findReservationsByCustomer(customerId);
	}

	@Override
	public List<Reservation> findReservationsByRoom(int roomId) {
		return reservationRepository.findReservationsByRoom(roomId);
	}

	@Override
	public List<Reservation> findReservationsPaidFor(boolean isPaid) {
		return reservationRepository.findReservationsPaidFor(isPaid);
	}

	@Override
	public boolean findIfRoomBooked(int roomId, Date startDate, Date endDate) {
		return reservationRepository.findIfRoomBooked(roomId, startDate, endDate);
	}

}
