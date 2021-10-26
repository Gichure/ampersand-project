package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.DriverDto;

/**
 * @author Paul
 * <p> The {@link Driver} service class interface
 */
public interface DriverServiceI {

	/**
	 * Saves a {@link Driver}
	 * 
	 * @param the {@link Driver} to save
	 * 
	 *  @return the saved {@link Driver} record
	 */
	public DriverDto save(DriverDto driver);
	
	
	/**
	 * Updates a {@link Driver}
	 * 
	 * @param {@link Driver} details to update
	 * @param id - the ID of the {@link Driver} to update. Rejected if not provided
	 * 
	 * @return the updated {@link Driver} record
	 * @throws Exception 
	 */
	public DriverDto update(DriverDto driver, Long id) throws Exception;
	
	/**
	 * Deletes a {@link Driver}
	 * 
	 * @param id - the ID of the {@link Driver} to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a {@link Driver} by ID
	 * 
	 * @param id - the ID of the {@link Driver} to find
	 * 
	 * @return the {@link Driver} record found
	 * @throws Exception 
	 */
	public DriverDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all {@link Driver}
	 * 
	 * @return the list of all {@link Driver}
	 */
	public List<DriverDto> findAll();
	
}
