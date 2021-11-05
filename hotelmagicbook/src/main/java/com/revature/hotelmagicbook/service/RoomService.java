/**
 * Service interface for the p2_rooms table
 */
package com.revature.hotelmagicbook.service;

import java.util.List;

import com.revature.hotelmagicbook.model.Room;

/**
 * @author Dipanjali Ghosh
 *
 */
public interface RoomService {

	public List<Room> findAll();

	public Room findById(int id);

	public void save(Room room);

	public void update(int id, Room room);

	public void delete(int id);

	public List<Room> findByRoomSize(int size);

	public List<Room> findByIsSmoking(boolean isSmoking);

	public List<Room> findRoomsBySizeAndIsSmoking(int size, boolean isSmoking);
}
