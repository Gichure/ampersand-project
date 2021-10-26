package com.pgichure.ampersand.operations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.operations.models.Transaction;

/**
 * @author Paul
 * <p> @Transaction data access object
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
