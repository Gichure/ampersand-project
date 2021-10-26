package com.pgichure.ampersand.operations.services;

import java.util.List;

import com.pgichure.ampersand.operations.dtos.TransactionDto;


/**
 * @author Paul
 * <p>The {@link Transaction} service class interface
 */
public interface TransactionServiceI {

	/**
	 * Saves a transaction
	 * 
	 * @param the transaction to save
	 * 
	 *  @return the saved transaction record
	 * @throws Exception 
	 */
	public TransactionDto save(TransactionDto transaction) throws Exception;
	
	
	/**
	 * Updates a transaction
	 * 
	 * @param transaction details to update
	 * @param id - the ID of the transaction to update. Rejected if not provided
	 * 
	 * @return the updated transaction record
	 * @throws Exception 
	 */
	public TransactionDto update(TransactionDto transaction, Long id) throws Exception;
	
	/**
	 * Deletes a transaction
	 * 
	 * @param id - the ID of the transaction to delete
	 * @throws Exception 
	 */
	public void deleteById(Long id) throws Exception;
	
	/**
	 * Finds a transaction by ID
	 * 
	 * @param id - the ID of the transaction to find
	 * 
	 * @return the transaction record found
	 * @throws Exception 
	 */
	public TransactionDto findById(Long id) throws Exception;
	
	/**
	 * Get a list of all transactions
	 * 
	 * @return the list of all transactions
	 */
	public List<TransactionDto> findAll();
	
}
