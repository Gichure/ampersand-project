package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.DriverDto;
import com.pgichure.ampersand.setups.dtos.DriverResponseDto;

/**
 * @author Paul
 * <p> The Driver service class interface
 */
public interface DriverServiceI {

	/**
	 * Saves a Driver
	 * 
	 * @param the Driver to save
	 * 
	 *  @return the saved Driver record
	 */
	public DriverDto save(DriverDto driver);
	
	
	/**
	 * Updates a Driver
	 * 
	 * @param Driver} details to update
	 * @param id - the ID of the Driver to update. Rejected if not provided
	 * 
	 * @return the updated Driver record
	 * @throws Exception 
	 */
	public DriverDto update(DriverDto driver, Long id) throws Exception;
	
	/**
	 * Deletes a Driver
	 * 
	 * @param id - the ID of the Driver to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a Driver} by ID
	 * 
	 * @param id - the ID of the Driver to find
	 * 
	 * @return the Driver record found
	 * @throws Exception 
	 */
	public DriverDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all Driver
	 * 
	 * @return the list of all Driver
	 */
	public List<DriverDto> findAll();
	
	/**
	 * Finds a Driver by ID, swaps and total consumption
	 * 
	 * @param id - the ID of the Driver to find
	 * 
	 * @return the Driver record found
	 * @throws Exception 
	 */
	public DriverResponseDto getTotalConsumption(Long id) throws Exception;
	
}
