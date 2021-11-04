/**
 * Implementing PriceGuideService
 */
package com.revature.hotelmagicbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbook.model.PriceGuide;
import com.revature.hotelmagicbook.repo.PriceGuideRepository;

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
	public PriceGuide findById(Pair<Integer, Boolean> priceId) {
		return priceGuideRepository.getById(priceId);
	}

	@Override
	public void save(PriceGuide priceGuide) {
		priceGuideRepository.save(priceGuide);

	}

	@Override
	public void update(Pair<Integer, Boolean> priceId, PriceGuide priceGuide) {
		priceGuideRepository.save(priceGuide);

	}

	@Override
	public void delete(Pair<Integer, Boolean> priceId) {
		priceGuideRepository.deleteById(priceId);

	}

}
