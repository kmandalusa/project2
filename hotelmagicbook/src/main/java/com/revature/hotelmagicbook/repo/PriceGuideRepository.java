package com.revature.hotelmagicbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import javafx.util.Pair; // Pair imported because PriceGuide has a composite Key

import com.revature.hotelmagicbook.model.PriceGuide;

public interface PriceGuideRepository extends JpaRepository<PriceGuide, Pair<Integer, Boolean>> {

}
