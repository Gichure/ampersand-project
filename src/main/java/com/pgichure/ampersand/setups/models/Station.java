package com.pgichure.ampersand.setups.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.ampersand.setups.dtos.StationDto;
import com.pgichure.ampersand.utils.Auditable;

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
public class Station extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "station_id", nullable = false)
    private Long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "coordinates", nullable = false)
    private String coordinates;
	
	@Column(name = "town", nullable = false)
    private String town;
	
	@Column(name = "street", nullable = false)
    private String street;
	
	@Column(name = "building")
    private String building;
	
	/**
	 * This method casts the {@link Station} entity class to its {@link StationDto}
	 * @return {@link StationDto}
	 */
	
	public StationDto getDto() {
		
		return StationDto.builder()
				.building(this.getBuilding())
				.coordinates(this.getCoordinates())
				.id(this.getId())
				.name(this.getName())
				.street(this.getStreet())
				.town(this.getTown())
				.build();
	}
	
}
