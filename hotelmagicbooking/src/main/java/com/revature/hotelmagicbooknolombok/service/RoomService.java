package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import com.revature.hotelmagicbooknolombok.model.RoomEntity;

public interface RoomService {

	List<RoomEntity> findAll();

	RoomEntity findByRoomId(int id);

	RoomEntity save(RoomEntity roomEntity);

	void update(int id, RoomEntity roomEntity);

	void delete(int id);

}
