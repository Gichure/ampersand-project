package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.CostSetupDto;

/**
 * @author Paul
 * <p> The CostSetup service class interface
 */
public interface CostSetupServiceI {

	/**
	 * Saves a setup
	 * 
	 * @param the setup to save
	 * 
	 *  @return the saved setup record
	 */
	public CostSetupDto save(CostSetupDto setup);
	
	
	/**
	 * Updates a setup
	 * 
	 * @param setup details to update
	 * @param id - the ID of the setup to update. Rejected if not provided
	 * 
	 * @return the updated setup record
	 */
	public CostSetupDto update(CostSetupDto setup, Long id);
	
	/**
	 * Deletes a setup
	 * 
	 * @param id - the ID of the setup to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a setup by ID
	 * 
	 * @param id - the ID of the setup to find
	 * 
	 * @return the setup record found
	 */
	public CostSetupDto findById(Long id);
	
	/**
	 * Get a list of all setups
	 * 
	 * @return the list of all setups
	 */
	public List<CostSetupDto> findAll();
	
}
