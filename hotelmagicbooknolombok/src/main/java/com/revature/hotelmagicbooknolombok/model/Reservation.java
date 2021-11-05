/**
 * Model Class for the p2_reservations table
 */
package com.revature.hotelmagicbooknolombok.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dipanjali Ghosh
 *
 */
@Entity
@Table(name = "p2_reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private int reservationId;
	@Column(name = "room_id")
	private int roomId;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "total_cost")
	private BigDecimal totalCost;
	@Column(name = "paid_for")
	private boolean paidFor;
	@Column(name = "time_made")
	private Timestamp timeMade;
	
	public Reservation() {
		super();
	}
	
	public Reservation(int reservationId, int roomId, int customerId, Date startDate, Date endDate,
			BigDecimal totalCost, boolean paidFor, Timestamp timeMade) {
		super();
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
		this.paidFor = paidFor;
		this.timeMade = timeMade;
	}

	/**
	 * @return the reservationId
	 */
	public int getReservationId() {
		return reservationId;
	}

	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the totalCost
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the paidFor
	 */
	public boolean isPaidFor() {
		return paidFor;
	}

	/**
	 * @param paidFor the paidFor to set
	 */
	public void setPaidFor(boolean paidFor) {
		this.paidFor = paidFor;
	}

	/**
	 * @return the timeMade
	 */
	public Timestamp getTimeMade() {
		return timeMade;
	}

	/**
	 * @param timeMade the timeMade to set
	 */
	public void setTimeMade(Timestamp timeMade) {
		this.timeMade = timeMade;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", roomId=" + roomId + ", customerId=" + customerId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalCost=$" + totalCost + ", paidFor="
				+ paidFor + ", timeMade=" + timeMade + "]";
	}
}
