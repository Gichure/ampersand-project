package com.pgichure.ampersand.operations.services;

import java.math.BigDecimal;
import java.util.List;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.models.Swap;

/**
 * @author Paul
 * <p>The {@link Swap} service class interface
 */
public interface SwapServiceI {

	/**
	 * Saves a swap
	 * 
	 * @param the swap to save
	 * 
	 *  @return the saved swap record
	 * @throws Exception 
	 */
	public SwapDto save(SwapDto swap) throws Exception;
	
	
	/**
	 * Updates a swap
	 * 
	 * @param swap details to update
	 * @param id - the ID of the swap to update. Rejected if not provided
	 * 
	 * @return the updated swap record
	 * @throws Exception 
	 */
	public SwapDto update(SwapDto swap, Long id) throws Exception;
	
	/**
	 * Deletes a swap
	 * 
	 * @param id - the ID of the swap to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a swap by ID
	 * 
	 * @param id - the ID of the swap to find
	 * 
	 * @return the swap record found
	 * @throws Exception 
	 */
	public SwapDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all swaps
	 * 
	 * @return the list of all swaps
	 */
	public List<SwapDto> findAll();
	
	/**
	 * Get a list of all swaps done by a given driver
	 * 
	 * @return the list of all swaps done by a given driver
	 */
	public List<SwapDto> findAllByIssuedToId(Long driverId);
	
	/**
	 * Get a total consumption by a driver
	 * 
	 * @return a total consumption by a driver
	 */
	public BigDecimal getTotalConsumptionByIssuedToId(Long driverId);
	
}
