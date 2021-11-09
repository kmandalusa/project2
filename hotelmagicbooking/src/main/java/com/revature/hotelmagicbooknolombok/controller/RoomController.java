/**
 * 
 */
package com.revature.hotelmagicbooknolombok.controller;

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

import com.revature.hotelmagicbooknolombok.model.RoomEntity;
import com.revature.hotelmagicbooknolombok.service.RoomService;

/**
 * @author Dipanjali Ghosh
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

	@Autowired
	RoomService roomService;

	@GetMapping("/rooms")
	public List<RoomEntity> getRooms() {
		return roomService.findAll();
	}

	@GetMapping("/rooms/{id}")
	public RoomEntity getRoomById(@PathVariable int id) {
		return roomService.findByRoomId(id);
	}

	@PostMapping("/rooms")
	public void saveCustomer(@RequestBody RoomEntity roomEntity) {
		roomService.save(roomEntity);
	}

	@PutMapping("/rooms/{id}")
	public void editRoom(@PathVariable int id, @RequestBody RoomEntity roomEntity) {
		roomService.save(roomEntity);
	}

	@DeleteMapping("/rooms/{id}")
	public void deleteRoomById(@PathVariable int id) {
		roomService.delete(id);
	}
}
