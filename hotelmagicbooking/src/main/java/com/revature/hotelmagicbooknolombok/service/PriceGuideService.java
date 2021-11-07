package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import com.revature.hotelmagicbooknolombok.model.PriceGuide;
import com.revature.hotelmagicbooknolombok.util.PriceGuideID;

public interface PriceGuideService{
	
	List<PriceGuide> findAll();
	
	PriceGuide findById(PriceGuideID priceId);
	
	void save(PriceGuide priceGuide);
	
	void update(PriceGuideID priceId, PriceGuide priceGuide);
	
	void delete(PriceGuideID priceId);

}
