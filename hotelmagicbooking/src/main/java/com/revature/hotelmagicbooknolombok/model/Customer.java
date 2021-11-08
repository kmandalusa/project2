/**
 * Model class for the p2_customers table
 */
package com.revature.hotelmagicbooknolombok.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Dipanjali Ghosh & Krishna Mandal
 *
 */
@Entity
@Table(name = "p2_customers")

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile")
	private long mobile;
//	@Column(name = "is_active")
//	private boolean isActive;

	public Customer(String email, String password, String name, long mobile) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		// this.isActive = isActive;
	}

}
