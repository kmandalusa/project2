package com.revature.hotelmagicbooknolombok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.hotelmagicbooknolombok.model.PriceGuide;
import com.revature.hotelmagicbooknolombok.util.PriceGuideID;

public interface PriceGuideRepository extends JpaRepository<PriceGuide, PriceGuideID> {

}
