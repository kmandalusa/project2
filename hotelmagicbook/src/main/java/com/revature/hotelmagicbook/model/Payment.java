/**
 * Model class for the p2_payment table
 */
package com.revature.hotelmagicbook.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dipanjali Ghosh
 *
 */
@Entity
@Table(name = "p2_payment")
public class Payment {
	@Id
	@Column(name = "card_number")
	private long cardNumber;
	@Column(name = "expiration_date")
	private Date expirationDate;
	@Column(name = "customer_id")
	private int customerId;
	
	public Payment() {
		super();
	}

	public Payment(long cardNumber, Date expirationDate, int customerId) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.customerId = customerId;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Payment [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", customerId=" + customerId
				+ "]";
	}
}
