package com.revature.hotelmagicbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hotelmagicbook.model.PriceGuide;
import com.revature.hotelmagicbook.service.PriceGuideService;
import com.revature.hotelmagicbook.util.PriceGuideID;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
public class PriceGuideController {

	@Autowired
	PriceGuideService priceGuideService;

	@GetMapping("/priceGuides")
	public List<PriceGuide> getPrices() {
		return priceGuideService.findAll();
	}

	@GetMapping("/priceGuides/{numBeds}/{allowsSmoke}")
	public PriceGuide getPriceById(@PathVariable("numBeds") int numBeds, @PathVariable("allowsSmoke") boolean allowsSmoke) {
		PriceGuideID priceId = new PriceGuideID(numBeds, allowsSmoke);
		return priceGuideService.findById(priceId);
	}

	@PostMapping("/priceGuides")
	public void savePriceGuide(@RequestBody PriceGuide priceGuide) {
		priceGuideService.save(priceGuide);
	}

	@PutMapping("/priceGuides/{numBeds}/{allowsSmoke}")
	public void editPriceGuide(@PathVariable("numBeds") int numBeds, @PathVariable("allowsSmoke") boolean allowsSmoke, @RequestBody PriceGuide priceGuide) {
		priceGuideService.save(priceGuide);
	}

	@DeleteMapping("/priceGuides/{numBeds}/{allowsSmoke}")
	public void deletePriceGuideById(@PathVariable("numBeds") int numBeds, @PathVariable("allowsSmoke") boolean allowsSmoke) {
		PriceGuideID priceId = new PriceGuideID(numBeds, allowsSmoke);
		priceGuideService.delete(priceId);
	}
}
