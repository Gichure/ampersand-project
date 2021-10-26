package com.pgichure.ampersand.setups.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * 
 * <p>This is the entity class for a battery swapping station
 *
 */
@Data
@RequiredArgsConstructor
@Table(name ="tbl_stations")
@EqualsAndHashCode(callSuper=false)
@Entity
@Builder
@AllArgsConstructor
public class Station implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The {@link Station} unique identifier
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "station_id", nullable = false)
    private Long id;
	
	/**
	 * The name of the station
	 */
	@Column(name = "name", nullable = false)
    private String name;
	
	/**
	 * The location coordinates of the station
	 */
	@Column(name = "coordinates", nullable = false)
    private String coordinates;
	
	/**
	 * The town of the station
	 */
	@Column(name = "town", nullable = false)
    private String town;
	
	/**
	 * The street of the station
	 */
	@Column(name = "street", nullable = false)
    private String street;
	
	/**
	 * The building of the station
	 */
	@Column(name = "building")
    private String building;
	
}
