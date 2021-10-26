package com.pgichure.ampersand.operations.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.TransactionDto;
import com.pgichure.ampersand.operations.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>The Transaction service class implementation
 */
@Service
@RequiredArgsConstructor
public class TransactionService implements TransactionServiceI{
	
	private final TransactionRepository repository;
	
	@Override
	public TransactionDto save(TransactionDto transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDto update(TransactionDto transaction, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
