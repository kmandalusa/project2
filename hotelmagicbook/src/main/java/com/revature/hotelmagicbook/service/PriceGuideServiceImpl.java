package com.revature.hotelmagicbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbook.repo.PriceGuideRepository;
import com.revature.hotelmagicbook.util.PriceGuideID;
import com.revature.hotelmagicbook.model.PriceGuide;

/**
 * @author Dipanjali Ghosh
 *
 */
@Service
public class PriceGuideServiceImpl implements PriceGuideService {

	@Autowired
	PriceGuideRepository priceGuideRepository;
	
	@Override
	public List<PriceGuide> findAll() {
		return priceGuideRepository.findAll();
	}

	@Override
	public PriceGuide findById(PriceGuideID priceId) {
		return priceGuideRepository.getById(priceId);
	}

	@Override
	public void save(PriceGuide priceGuide) {
		priceGuideRepository.save(priceGuide);

	}

	@Override
	public void update(PriceGuideID priceId, PriceGuide priceGuide) {
		priceGuideRepository.save(priceGuide);

	}

	@Override
	public void delete(PriceGuideID priceId) {
		priceGuideRepository.deleteById(priceId);

	}

}

