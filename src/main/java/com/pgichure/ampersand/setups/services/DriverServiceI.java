package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.DriverDto;

/**
 * @author Paul
 * <p> The Driver service class interface
 */
public interface DriverServiceI {

	/**
	 * Saves a driver
	 * 
	 * @param the driver to save
	 * 
	 *  @return the saved driver record
	 */
	public DriverDto save(DriverDto driver);
	
	
	/**
	 * Updates a driver
	 * 
	 * @param driver details to update
	 * @param id - the ID of the driver to update. Rejected if not provided
	 * 
	 * @return the updated driver record
	 */
	public DriverDto update(DriverDto driver, Long id);
	
	/**
	 * Deletes a driver
	 * 
	 * @param id - the ID of the driver to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a driver by ID
	 * 
	 * @param id - the ID of the driver to find
	 * 
	 * @return the driver record found
	 */
	public DriverDto findById(Long id);
	
	/**
	 * Get a list of all drivers
	 * 
	 * @return the list of all drivers
	 */
	public List<DriverDto> findAll();
	
}
