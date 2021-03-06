package com.pgichure.ampersand.setups.services;

import java.util.List;

import com.pgichure.ampersand.setups.dtos.MotorCycleDto;
import com.pgichure.ampersand.setups.dtos.MotorCycleResponseDto;
import com.pgichure.ampersand.setups.models.MotorCycle;

/**
 * @author Paul
 * p> The {@link MotorCycle} service class interface
 */
public interface MotorCycleServiceI {

	/**
	 * Saves a {@link MotorCycle}
	 * 
	 * @param the {@link MotorCycle} to save
	 * 
	 *  @return the saved {@link MotorCycle}rCycle} record
	 * @throws Exception 
	 */
	public MotorCycleDto save(MotorCycleDto motorCycle) throws Exception;
	
	
	/**
	 * Updates a {@link MotorCycle}
	 * 
	 * @param {@link MotorCycle} details to update
	 * @param id - the ID of the {@link MotorCycle} to update. Rejected if not provided
	 * 
	 * @return the updated {@link MotorCycle} record
	 * @throws Exception 
	 */
	public MotorCycleDto update(MotorCycleDto motorCycle, Long id) throws Exception;
	
	/**
	 * Deletes a {@link MotorCycle}
	 * 
	 * @param id - the ID of the {@link MotorCycle} to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a {@link MotorCycle} by ID
	 * 
	 * @param id - the ID of the {@link MotorCycle} to find
	 * 
	 * @return the {@link MotorCycle} record found
	 * @throws Exception 
	 */
	public MotorCycleResponseDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all {@link MotorCycle}
	 * 
	 * @return the list of all {@link MotorCycle}
	 * @throws Exception 
	 */
	public List<MotorCycleResponseDto> findAll() throws Exception;


	/**
	 * @param motorCycle the motor cycle to assign
	 * @param id
	 * @return MotorCycleDto
	 * @throws Exception 
	 */
	public MotorCycleDto assign(MotorCycleDto motorCycle, Long id) throws Exception;
	
}
