package com.revature.hotelmagicbook.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.hotelmagicbook.util.PriceGuideID;

/**
 * @author Dipanjali Ghosh
 *
 */
@Entity
@IdClass(PriceGuideID.class)
@Table(name = "p2_price_guide")
@JsonSerialize
public class PriceGuide {
	@Id
	@Column(name = "number_beds")
	private int numberBeds;
	@Id
	@Column(name = "is_smoking")
	private boolean isSmoking;
	@Column(name = "price_per_day")
	private BigDecimal pricePerDay;
	
	public PriceGuide() {
		super();
	}

	public PriceGuide(int numberBeds, boolean isSmoking, BigDecimal pricePerDay) {
		super();
		this.numberBeds = numberBeds;
		this.isSmoking = isSmoking;
		this.pricePerDay = pricePerDay;
	}
	
	public PriceGuide(PriceGuideID key, BigDecimal pricePerDay) {
		super();
		this.numberBeds = key.getNumberBeds();
		this.isSmoking = key.isIsSmoking();
		this.pricePerDay = pricePerDay;
	}

	public int getNumberBeds() {
		return numberBeds;
	}

	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}

	public boolean isSmoking() {
		return isSmoking;
	}

	public void setSmoking(boolean isSmoking) {
		this.isSmoking = isSmoking;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString() {
		return "PriceGuide [numberBeds=" + numberBeds + ", isSmoking=" + isSmoking + ", pricePerDay=$" + pricePerDay
				+ "]";
	}
}
