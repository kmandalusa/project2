/**
 * Repository Interface for p2_reservations table
 */
package com.revature.hotelmagicbooknolombok.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbooknolombok.model.Reservation;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	public List<Reservation> findReservationsByCustomerId(int customerId);
	
	public List<Reservation> findReservationsByRoomId(int roomId);
	
	public List<Reservation> findReservationsByPaidFor(boolean isPaid);
	
	public boolean findIfRoomBooked(int roomId, Date startDate, Date endDate);
}
