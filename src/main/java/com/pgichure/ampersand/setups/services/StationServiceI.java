package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.StationDto;

/**
 * @author Paul
 * <p> The Station service class interface
 */
public interface StationServiceI {

	/**
	 * Saves a station
	 * 
	 * @param the station to save
	 * 
	 *  @return the saved station record
	 */
	public StationDto save(StationDto station);
	
	
	/**
	 * Updates a station
	 * 
	 * @param station details to update
	 * @param id - the ID of the station to update. Rejected if not provided
	 * 
	 * @return the updated station record
	 */
	public StationDto update(StationDto station, Long id);
	
	/**
	 * Deletes a station
	 * 
	 * @param id - the ID of the station to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a station by ID
	 * 
	 * @param id - the ID of the station to find
	 * 
	 * @return the station record found
	 */
	public StationDto findById(Long id);
	
	/**
	 * Get a list of all stations
	 * 
	 * @return the list of all stations
	 */
	public List<StationDto> findAll();
	
}
