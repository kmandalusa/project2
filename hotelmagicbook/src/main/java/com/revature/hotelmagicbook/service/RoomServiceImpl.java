/**
 * Implementation for the RoomService interface
 */
package com.revature.hotelmagicbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbook.model.Room;
import com.revature.hotelmagicbook.repo.RoomRepository;

/**
 * @author Dipanjali Ghosh
 *
 */
@Service
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
	public List<Room> findByRoomSize(int size) {
		return roomRepository.findByRoomSize(size);
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
