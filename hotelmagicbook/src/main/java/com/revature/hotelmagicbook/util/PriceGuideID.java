/**
 * Utility class for making the Composite Key used in the 
 * 		p2_price_guide table
 * 
 * Reference: https://www.baeldung.com/jpa-composite-primary-keys
 */
package com.revature.hotelmagicbook.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dipanjali Ghosh
 *
 */
public class PriceGuideID implements Serializable {
    /**
	 * Not sure what the purpose of serialVersionUID is.
	 */
	private static final long serialVersionUID = -6481951513215137653L;

	private int numberBeds;

    private boolean isSmoking;

    // default constructor

    public PriceGuideID(int numberBeds, boolean isSmoking) {
        this.numberBeds = numberBeds;
        this.isSmoking = isSmoking;
    }
    
    // equals() and hashCode()
    
	/**
	 * @return the numberBeds
	 */
	public int getNumberBeds() {
		return numberBeds;
	}



	/**
	 * @param numberBeds the numberBeds to set
	 */
	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}



	/**
	 * @return the is_smoking
	 */
	public boolean isIsSmoking() {
		return isSmoking;
	}



	/**
	 * @param is_smoking the is_smoking to set
	 */
	public void setIsSmoking(boolean isSmoking) {
		this.isSmoking = isSmoking;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(isSmoking, numberBeds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceGuideID other = (PriceGuideID) obj;
		return isSmoking == other.isSmoking && numberBeds == other.numberBeds;
	}
}