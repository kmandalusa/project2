/**
 * Implementing the ReservationService Interface
 */
package com.revature.hotelmagicbooknolombok.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbooknolombok.model.Reservation;
import com.revature.hotelmagicbooknolombok.repo.ReservationRepository;

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
	public List<Reservation> findReservationsByCustomerId(int customerId) {
		return reservationRepository.findReservationsByCustomerId(customerId);
	}

	@Override
	public List<Reservation> findReservationsByRoomId(int roomId) {
		return reservationRepository.findReservationsByRoomId(roomId);
	}

	@Override
	public List<Reservation> findReservationsByPaidFor(boolean isPaid) {
		return reservationRepository.findReservationsByPaidFor(isPaid);
	}

	@Override
	public boolean findIfRoomBooked(int roomId, Date startDate, Date endDate) throws Exception {
		if (startDate.after(endDate)) // makes no sense to have the start date be after the end date
		{
			System.out.println("User has input the startDate to be after the endDate."
					+ " This function requires the startDate to be before the endDate or the same day if User is staying for one day.");
			throw new Exception(
					"User start of reservation block not allowed to be after the end of the reservation block.");
		}
		List<Reservation> reservations = reservationRepository.findReservationsByRoomId(roomId);
		// List<Reservation> reservations = reservationRepository.findAll();
		if (reservations.isEmpty()) // meaning no one has EVER booked in this hotel before
		{
			return false;
		} else {
//			boolean[] toRemove = new boolean[reservations.size()];
//			for(int i = 0; i < reservations.size(); i++)
//			{
//				if(reservations.get(i).getRoomId() == roomId)
//				{
//					toRemove[i] = false;
//				}
//				else
//				{
//					toRemove[i] = true;
//				}
//			}
//			
//			for(int j = reservations.size()-1; j >= 0; j--)
//			{
//				if(toRemove[j])
//				{
//					reservations.remove(j);
//				}
//			}
//			if(reservations.isEmpty()) // meaning no one has EVER booked in this specific room before
//			{
//				return false;
//			}
			for (Reservation x : reservations) {
				if (startDate.after(x.getStartDate()) && startDate.before(x.getEndDate())) {
					return true; // if it starts in the middle of another reservation, it is booked.
				} else if (startDate.equals(x.getStartDate()) || startDate.equals(x.getEndDate())) {
					return true; // if it starts on the same day as another reservation, it is booked.
				} else // we assume that startDate.before(x.getStartDate()) is true in this case
				{
					if (startDate.before(x.getStartDate()) && !endDate.before(x.getStartDate())) {
						if (!x.isPaidFor()) {
							System.out.println("Customer " + x.getCustomerId()
									+ " needs to pay for their reservation for room " + x.getRoomId() + "!");
						}
						return true; // the reservation overlaps in this case.
					}
				}
			}
		}

		return false;
//		return reservationRepository.findIfRoomBooked(roomId, startDate, endDate);
	}

}
