package com.pgichure.ampersand.operations.services;

import java.util.List;

import com.pgichure.ampersand.operations.dtos.TransactionDto;


/**
 * @author Paul
 * <p>The Transaction service class interface
 */
public interface TransactionServiceI {

	/**
	 * Saves a transaction
	 * 
	 * @param the transaction to save
	 * 
	 *  @return the saved transaction record
	 */
	public TransactionDto save(TransactionDto transaction);
	
	
	/**
	 * Updates a transaction
	 * 
	 * @param transaction details to update
	 * @param id - the ID of the transaction to update. Rejected if not provided
	 * 
	 * @return the updated transaction record
	 */
	public TransactionDto update(TransactionDto transaction, Long id);
	
	/**
	 * Deletes a transaction
	 * 
	 * @param id - the ID of the transaction to delete
	 */
	public void deleteById(Long id);
	
	/**
	 * Finds a transaction by ID
	 * 
	 * @param id - the ID of the transaction to find
	 * 
	 * @return the transaction record found
	 */
	public TransactionDto findById(Long id);
	
	/**
	 * Get a list of all transactions
	 * 
	 * @return the list of all transactions
	 */
	public List<TransactionDto> findAll();
	
}
