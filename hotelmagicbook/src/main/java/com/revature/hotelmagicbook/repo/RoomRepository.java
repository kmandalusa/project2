/**
 * Repository interface for the p2_rooms table
 */
package com.revature.hotelmagicbook.repo;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hotelmagicbook.model.Room;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {
//	public List<Room> findBySize(int size);
//	
//	public List<Room> findSmoking(boolean isSmoking);
//	
//	public List<Room> findRoomsByType(int size, boolean isSmoking);
}
