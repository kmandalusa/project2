/**
 * Repository interface for the p2_rooms table
 */
package com.revature.hotelmagicbooknolombok.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbooknolombok.model.Room;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {
	public List<Room> findBySize(int size);
	
	public List<Room> findByIsSmoking(boolean isSmoking);
	
	public List<Room> findRoomsBySizeAndIsSmoking(int size, boolean isSmoking);
}
