package com.revature.hotelmagicbook.service;

import java.util.List;

import com.revature.hotelmagicbook.model.PriceGuide;
import com.revature.hotelmagicbook.util.PriceGuideID;

public interface PriceGuideService{
	
	List<PriceGuide> findAll();
	
	PriceGuide findById(PriceGuideID priceId);
	
	void save(PriceGuide priceGuide);
	
	void update(PriceGuideID priceId, PriceGuide priceGuide);
	
	void delete(PriceGuideID priceId);

}
