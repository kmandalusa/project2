/**
 * Controller class for the p2_rooms table
 */
package com.revature.hotelmagicbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hotelmagicbook.model.Room;
import com.revature.hotelmagicbook.service.RoomService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class RoomController {

	@Autowired
	RoomService roomService;

	@GetMapping("/rooms")
	public List<Room> getRooms() {
		log.info("Getting all the records in the Rooms database.");
		return roomService.findAll();
	}

	@GetMapping("/rooms/{id}")
	public Room getRoomById(@PathVariable int id) {
		return roomService.findById(id);
	}
	
	@GetMapping("/rooms/searchBySize/{size}")
	public List<Room> getRoomsByRoomSize(@PathVariable int size) {
		return roomService.findByRoomSize(size);
	}
	
	@GetMapping("/rooms/searchSmoking/{smokes}")
	public List<Room> getRoomsWithSmoke(@PathVariable boolean smokes) {
		return roomService.findByIsSmoking(smokes);
	}
	
	@GetMapping("/rooms/searchByType/{size}/{smokes}")
	public List<Room> getRoomsByRoomSizeAndIsSmoking(@PathVariable("size") int size, @PathVariable("smokes") boolean smokes) {
		return roomService.findRoomsByRoomSizeAndIsSmoking(size, smokes);
	}

	@PostMapping("/rooms")
	public void saveRoom(@RequestBody Room room) {
		roomService.save(room);
	}

	@PutMapping("/rooms/{id}")
	public void editRoom(@PathVariable int id, @RequestBody Room room) {
		roomService.save(room);
	}

	@DeleteMapping("/rooms/{id}")
	public void deleteRoomById(@PathVariable int id) {
		roomService.delete(id);
	}
}
