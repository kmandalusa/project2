/**
 * Utility class for making the Composite Key used in the 
 * 		p2_price_guide table
 * 
 * Reference: https://www.baeldung.com/jpa-composite-primary-keys
 */
package com.revature.hotelmagicbooknolombok.util;

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