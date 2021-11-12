package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.hotelmagicbooknolombok.HotelmagicbooknolombokApplicationTests;
import com.revature.hotelmagicbooknolombok.model.RoomEntity;

public class RoomServiceImplTest extends HotelmagicbooknolombokApplicationTests {

	@Autowired
	private RoomService roomService;

	@Test
	@DisplayName("Test for Save a room")
	@Order(1)
	public void saveRoomTest() {
		RoomEntity room = new RoomEntity(1, 135.00);
		try {
			roomService.save(room);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Test for findAll method")
	@Order(2)
	public void findAllRoomsTest() {
		roomService.save(new RoomEntity(1, 135.00));
		roomService.save(new RoomEntity(2, 150.00));
		List<RoomEntity> rooms = roomService.findAll();
		Assertions.assertEquals(rooms.size() >= 2, true);
		Assertions.assertEquals(rooms.size() == 0, false);
	}

	@Test
	@DisplayName("Test for Delete method")
	@Order(3)
	public void testDelete() {
		RoomEntity room1 = roomService.save(new RoomEntity(3, 155.00));
		int id = room1.getRoomId();
		System.out.println("Id : "+ id );
		roomService.delete(id);
		//Assertions.assertNull(roomService.findByRoomId(id));
	}
}
