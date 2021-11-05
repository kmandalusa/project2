/**
 * Service interface for p2_reservations
 */
package com.revature.hotelmagicbook.service;

import java.sql.Date;
import java.util.List;

import com.revature.hotelmagicbook.model.Reservation;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface ReservationService {
	public List<Reservation> findAll();

	public Reservation findById(int id);

	public void save(Reservation reservation);

	public void update(int id, Reservation reservation);

	public void delete(int id);
	
	public List<Reservation> findReservationsByCustomerId(int customerId);

	public List<Reservation> findReservationsByRoomId(int roomId);

	public List<Reservation> findReservationsByPaidFor(boolean isPaid);

	public boolean findIfRoomBooked(int roomId, Date startDate, Date endDate) throws Exception;
}
