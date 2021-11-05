/**
 * Implementation for the RoomService interface
 */
package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.hotelmagicbooknolombok.model.Room;
import com.revature.hotelmagicbooknolombok.repo.RoomRepository;

/**
 * @author Dipanjali Ghosh
 *
 */
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public Room findById(int id) {
		return roomRepository.getById(id);
	}

	@Override
	public void save(Room room) {
		roomRepository.save(room);
	}

	@Override
	public void update(int id, Room room) {
		roomRepository.save(room);
	}

	@Override
	public void delete(int id) {
		roomRepository.deleteById(id);
	}

	@Override
	public List<Room> findBySize(int size) {
		return roomRepository.findBySize(size);
	}

	@Override
	public List<Room> findByIsSmoking(boolean isSmoking) {
		return roomRepository.findByIsSmoking(isSmoking);
	}

	@Override
	public List<Room> findRoomsBySizeAndIsSmoking(int size, boolean isSmoking) {
		return roomRepository.findRoomsBySizeAndIsSmoking(size, isSmoking);
	}

}
