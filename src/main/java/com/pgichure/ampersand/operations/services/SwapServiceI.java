package com.pgichure.ampersand.operations.services;

import java.util.List;

import com.pgichure.ampersand.operations.dtos.SwapDto;

/**
 * @author Paul
 * <p>The Swap service class interface
 */
public interface SwapServiceI {

	/**
	 * Saves a swap
	 * 
	 * @param the swap to save
	 * 
	 *  @return the saved swap record
	 */
	public SwapDto save(SwapDto swap);
	
	
	/**
	 * Updates a swap
	 * 
	 * @param swap details to update
	 * @param id - the ID of the swap to update. Rejected if not provided
	 * 
	 * @return the updated swap record
	 */
	public SwapDto update(SwapDto swap, Long id);
	
	/**
	 * Deletes a swap
	 * 
	 * @param id - the ID of the swap to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a swap by ID
	 * 
	 * @param id - the ID of the swap to find
	 * 
	 * @return the swap record found
	 */
	public SwapDto findById(Long id);
	
	/**
	 * Get a list of all swaps
	 * 
	 * @return the list of all swaps
	 */
	public List<SwapDto> findAll();
	
}
