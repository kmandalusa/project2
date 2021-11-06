/**
 * Controller class meant to get all the room details.
 * It's in the util folder because getting the details requires joining different tables together.
 */
package com.revature.hotelmagicbook.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.hotelmagicbook.model.PriceGuide;
import com.revature.hotelmagicbook.model.Room;
import com.revature.hotelmagicbook.service.PriceGuideService;
import com.revature.hotelmagicbook.service.RoomService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
@Slf4j
public class RoomDetailsController {
	@Autowired
	RoomService roomService;
	
	@Autowired
	PriceGuideService priceGuideService;
	
	/**
	 * Internal class declared to put all the details needed for specific rooms in one object.
	 * 
	 * */
	@JsonSerialize
	private class RoomDetails{
		Room room;
		PriceGuide price;
		
		RoomDetails(Room room, PriceGuide price){
			super();
			this.room = room;
			this.price = price;
		}
		
		public String toString() {
			if(room.isSmoking())
			{
				return "Room " + room.getRoomId() + "seats " + room.getRoomSize() + ", allows smoking, and costs $"
						+ price.getPricePerDay() + " per night.";
			}
			else
			{
				return "Room " + room.getRoomId() + "seats " + room.getRoomSize() + ", does not allow smoking, and costs $"
						+ price.getPricePerDay() + " per night.";
			}
		}
	}
	
	@GetMapping("/roomdetails")
	public List<RoomDetails> getDetails()
	{
		log.info("Entering getDetails method");
		List<Room> allRooms = roomService.findAll();
		List<RoomDetails> result = null;
		result = new ArrayList<RoomDetails>();
		
		log.info("Starting iterations to build the list to return.");
		//Iterate through all the rooms to build result;
		for(Room x : allRooms)
		{
			result.add(new RoomDetails(x, priceGuideService.findById(new PriceGuideID(x.getRoomSize(), x.isSmoking()))));
		}
		log.info("Returning result");
		
		return result;
	}
}
