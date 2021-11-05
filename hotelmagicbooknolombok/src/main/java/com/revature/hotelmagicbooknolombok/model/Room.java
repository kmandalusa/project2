/**
 * Model class for the p2_rooms table
 */
package com.revature.hotelmagicbooknolombok.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dipanjali Ghosh
 *
 */
@Entity
@Table(name = "p2_rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int roomId;
	@Column(name = "room_size")
	private int roomSize;
	@Column(name = "room_smokes")
	private boolean isSmoking;
	
	public Room() {
		super();
	}
	
	public Room(int roomId, int roomSize, boolean isSmoking) {
		super();
		this.roomId = roomId;
		this.roomSize = roomSize;
		this.isSmoking = isSmoking;
	}
	
	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomSize
	 */
	public int getRoomSize() {
		return roomSize;
	}

	/**
	 * @param roomSize the roomSize to set
	 */
	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	/**
	 * @return the isSmoking
	 */
	public boolean isSmoking() {
		return isSmoking;
	}

	/**
	 * @param isSmoking the isSmoking to set
	 */
	public void setSmoking(boolean isSmoking) {
		this.isSmoking = isSmoking;
	}
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomSize=" + roomSize + ", isSmoking=" + isSmoking + "]";
	}
}
