package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.StationDto;
import com.pgichure.ampersand.setups.models.Station;

/**
 * @author Paul
 * <p> The {@link Station} service class interface
 */
public interface StationServiceI {

	/**
	 * Saves a {@link Station}
	 * 
	 * @param the {@link Station} to save
	 * 
	 *  @return the saved {@link Station} record
	 * @throws Exception 
	 */
	public StationDto save(StationDto station) throws Exception;
	
	
	/**
	 * Updates a {@link Station}
	 * 
	 * @param {@link Station} details to update
	 * @param id - the ID of the {@link Station} to update. Rejected if not provided
	 * 
	 * @return the updated {@link Station} record
	 * @throws Exception 
	 */
	public StationDto update(StationDto station, Long id) throws Exception;
	
	/**
	 * Deletes a {@link Station}
	 * 
	 * @param id - the ID of the {@link Station} to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a {@link Station} by ID
	 * 
	 * @param id - the ID of the {@link Station} to find
	 * 
	 * @return the {@link Station} record found
	 * @throws Exception 
	 */
	public StationDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all {@link Station}
	 * 
	 * @return the list of all {@link Station}
	 */
	public List<StationDto> findAll();
	
}
