package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.setups.models.Battery;

/**
 * @author Paul
 * <p>The {@link Battery} service class interface
 */
public interface BatteryServiceI {
	
	/**
	 * Saves a {@link Battery}
	 * 
	 * @param the {@link Battery} to save
	 * 
	 *  @return the saved {@link Battery} record
	 */
	public BatteryDto save(BatteryDto battery);
	
	
	/**
	 * Updates a {@link Battery}
	 * 
	 * @param {@link Battery} details to update
	 * @param id - the ID of the {@link Battery} to update. Rejected if not provided
	 * 
	 * @return the updated {@link Battery} record
	 * @throws Exception 
	 */
	public BatteryDto update(BatteryDto battery, Long id) throws Exception;
	
	/**
	 * Deletes a {@link Battery}
	 * 
	 * @param id - the ID of the {@link Battery} to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a {@link Battery} by ID
	 * 
	 * @param id - the ID of the {@link Battery} to find
	 * 
	 * @return the {@link Battery} record found
	 * @throws Exception 
	 */
	public BatteryDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all {@link Battery}
	 * 
	 * @return the list of all {@link Battery}
	 */
	public List<BatteryDto> findAll();
	

}
