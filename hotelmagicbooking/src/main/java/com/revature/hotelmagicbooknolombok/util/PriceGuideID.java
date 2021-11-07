/**
 * Utility class for making the Composite Key used in the 
 * 		p2_price_guide table
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

    private boolean is_smoking;

    // default constructor

    public PriceGuideID(int numberBeds, boolean is_smoking) {
        this.numberBeds = numberBeds;
        this.is_smoking = is_smoking;
    }

    // equals() and hashCode()
    
	@Override
	public int hashCode() {
		return Objects.hash(is_smoking, numberBeds);
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
		return is_smoking == other.is_smoking && numberBeds == other.numberBeds;
	}
}