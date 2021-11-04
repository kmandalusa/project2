package com.revature.hotelmagicbook.service;

import java.util.List;

import javafx.util.Pair;

import com.revature.hotelmagicbook.model.PriceGuide;

public interface PriceGuideService{
	
	List<PriceGuide> findAll();
	
	PriceGuide findById(Pair<Integer, Boolean> priceId);
	
	void save(PriceGuide priceGuide);
	
	void update(Pair<Integer, Boolean> priceId, PriceGuide priceGuide);
	
	void delete(Pair<Integer, Boolean> priceId);

}
