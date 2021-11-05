/**
 * Service interface for the p2_rooms table
 */
package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import com.revature.hotelmagicbooknolombok.model.Room;

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

	public List<Room> findBySize(int size);

	public List<Room> findSmoking(boolean isSmoking);

	public List<Room> findRoomsByType(int size, boolean isSmoking);
}