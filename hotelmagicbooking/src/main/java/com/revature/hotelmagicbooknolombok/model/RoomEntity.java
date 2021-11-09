/**
 * 
 */
package com.revature.hotelmagicbooknolombok.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Dipanjali Ghosh
 *
 */
@Entity
@Table(name = "p2_room_entity")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int roomId;
	@Column(name = "num_beds")
	private int numBeds;
	private BigDecimal price;

}
