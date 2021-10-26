package com.pgichure.ampersand.operations.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.TransactionDto;
import com.pgichure.ampersand.operations.models.Swap;
import com.pgichure.ampersand.operations.models.Transaction;
import com.pgichure.ampersand.operations.repositories.SwapRepository;
import com.pgichure.ampersand.operations.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>The {@link Transaction} service class implementation
 */
@Service
@RequiredArgsConstructor
public class TransactionService implements TransactionServiceI{
	
	private final TransactionRepository repository;
	
	private final SwapRepository swapRepository;
	
	@Override
	public TransactionDto save(TransactionDto dto) throws Exception{
		Swap swap = swapRepository.findById(dto.getSwapId())
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		Transaction transaction = dto.getEntity();
		transaction.setSwap(swap);
		transaction = repository.save(transaction);
		return transaction.getDto();
	}

	@Override
	public TransactionDto update(TransactionDto dto, Long id) throws Exception{
		
		Swap swap = swapRepository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		Transaction transaction = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		transaction = dto.getEntity();
		transaction.setSwap(swap);		
		transaction = repository.save(transaction);
		return transaction.getDto();
	}

	@Override
	public void deleteById(Long id) throws Exception{
		Transaction transaction = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		repository.delete(transaction);
	}

	@Override
	public TransactionDto findById(Long id) throws Exception{
		Transaction transaction = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
	
		return transaction.getDto();
	}

	@Override
	public List<TransactionDto> findAll() {
		List<Transaction> transactions = repository.findAll();
		return transactions.stream().map(transaction -> transaction.getDto())
                .collect(Collectors.toList());
	}
	
}
