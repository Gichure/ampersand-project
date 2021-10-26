package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.MotorCycleDto;

/**
 * @author Paul
 * p> The MotorCycle service class interface
 */
public interface MotorCycleServiceI {

	/**
	 * Saves a motor cycle
	 * 
	 * @param the motor cycle to save
	 * 
	 *  @return the saved motor cycle record
	 */
	public MotorCycleDto save(MotorCycleDto motorCycle);
	
	
	/**
	 * Updates a motor cycle
	 * 
	 * @param motor cycle details to update
	 * @param id - the ID of the motor cycle to update. Rejected if not provided
	 * 
	 * @return the updated motor cycle record
	 */
	public MotorCycleDto update(MotorCycleDto motorCycle, Long id);
	
	/**
	 * Deletes a motor cycle
	 * 
	 * @param id - the ID of the motor cycle to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a motor cycle by ID
	 * 
	 * @param id - the ID of the motor cycle to find
	 * 
	 * @return the motor cycle record found
	 */
	public MotorCycleDto findById(Long id);
	
	/**
	 * Get a list of all motor cycles
	 * 
	 * @return the list of all motor cycles
	 */
	public List<MotorCycleDto> findAll();
	
}
