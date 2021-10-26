package com.pgichure.ampersand.setups.services;

import java.util.Date;
import java.util.List;

import com.pgichure.ampersand.setups.dtos.CostSetupDto;
import com.pgichure.ampersand.setups.models.CostSetup;

/**
 * @author Paul
 * <p> The {@link CostSetup} service class interface
 */
public interface CostSetupServiceI {

	/**
	 * Saves a {@link CostSetup}
	 * 
	 * @param the {@link CostSetup} to save
	 * 
	 *  @return the saved {@link CostSetup} record
	 */
	public CostSetupDto save(CostSetupDto setup);
	
	
	/**
	 * Updates a {@link CostSetup}
	 * 
	 * @param {@link CostSetup} details to update
	 * @param id - the ID of the {@link CostSetup} to update. Rejected if not provided
	 * 
	 * @return the updated {@link CostSetup} record
	 * @throws Exception 
	 */
	public CostSetupDto update(CostSetupDto setup, Long id) throws Exception;
	
	/**
	 * Deletes a {@link CostSetup}
	 * 
	 * @param id - the ID of the {@link CostSetup} to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a {@link CostSetup} by ID
	 * 
	 * @param id - the ID of the {@link CostSetup} to find
	 * 
	 * @return the {@link CostSetup} record found
	 * @throws Exception 
	 */
	public CostSetupDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all setups
	 * 
	 * @return the list of all setups
	 */
	public List<CostSetupDto> findAll();
	
	
	/**
	 * Get the effective cost setup
	 * 
	 * @return the setup
	 */
	public CostSetup findAllAsAt(Date asAt);
	
}
