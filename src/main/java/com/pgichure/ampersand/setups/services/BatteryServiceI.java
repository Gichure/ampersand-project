package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.BatteryDto;

/**
 * @author Paul
 * <p>The Battery service class interface
 */
public interface BatteryServiceI {
	
	/**
	 * Saves a battery
	 * 
	 * @param the battery to save
	 * 
	 *  @return the saved battery record
	 */
	public BatteryDto save(BatteryDto battery);
	
	
	/**
	 * Updates a battery
	 * 
	 * @param battery details to update
	 * @param id - the ID of the battery to update. Rejected if not provided
	 * 
	 * @return the updated battery record
	 */
	public BatteryDto update(BatteryDto battery, Long id);
	
	/**
	 * Deletes a battery
	 * 
	 * @param id - the ID of the battery to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a battery by ID
	 * 
	 * @param id - the ID of the battery to find
	 * 
	 * @return the battery record found
	 */
	public BatteryDto findById(Long id);
	
	/**
	 * Get a list of all batteries
	 * 
	 * @return the list of all batteries
	 */
	public List<BatteryDto> findAll();
	

}
