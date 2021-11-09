/**
 * 
 */
package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmagicbooknolombok.model.RoomEntity;
import com.revature.hotelmagicbooknolombok.repo.RoomRepository;

/**
 * @author Dipanjali Ghosh
 *
 */
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public List<RoomEntity> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public RoomEntity findByRoomId(int id) {
		return roomRepository.getById(id);
	}

	@Override
	public RoomEntity save(RoomEntity roomEntity) {
		return roomRepository.save(roomEntity);
	}

	@Override
	public void update(int id, RoomEntity roomEntity) {
		roomRepository.save(roomEntity);

	}

	@Override
	public void delete(int id) {
		roomRepository.deleteById(id);

	}

}
