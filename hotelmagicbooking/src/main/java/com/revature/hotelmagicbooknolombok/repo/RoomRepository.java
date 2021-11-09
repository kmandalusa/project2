package com.revature.hotelmagicbooknolombok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbooknolombok.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
	public RoomEntity findByRoomId(int id);
}
