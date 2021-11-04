/**
 * Model class for the p2_customers table
 */
package com.revature.hotelmagicbook.model;

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
@Table(name = "p2_customers")
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
	@Column(name = "is_active")
	private boolean isActive;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String email, String password, String name, long mobile, boolean isActive) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.isActive = isActive;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", mobile=" + mobile + ", isActive=" + isActive + "]";
	}
}
