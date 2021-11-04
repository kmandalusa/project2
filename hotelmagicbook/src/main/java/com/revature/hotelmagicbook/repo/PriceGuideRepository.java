package com.revature.hotelmagicbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.hotelmagicbook.model.PriceGuide;
import com.revature.hotelmagicbook.util.PriceGuideID;

public interface PriceGuideRepository extends JpaRepository<PriceGuide, PriceGuideID> {

}
