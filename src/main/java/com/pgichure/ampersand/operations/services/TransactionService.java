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
		Transaction transaction = this.getEntity(dto);
		transaction = repository.save(transaction);
		return this.getDto(transaction);
	}

	@Override
	public TransactionDto update(TransactionDto dto, Long id) throws Exception{
		Transaction transaction = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		transaction = this.getEntity(dto);
		transaction = repository.save(transaction);
		return this.getDto(transaction);
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
	
		return this.getDto(transaction);
	}

	@Override
	public List<TransactionDto> findAll() {
		List<Transaction> transactions = repository.findAll();
		return transactions.stream().map(transaction ->this.getDto(transaction))
                .collect(Collectors.toList());
	}
	
	/**
	 * This method casts the {@link Transaction} entity class to its {@link TransactionDto}
	 * @return {@link TransactionDto}
	 */
	private TransactionDto getDto(Transaction transaction) {
		
		return TransactionDto.builder()
				.charges(transaction.getCharges())
				.cost_per_unit(transaction.getCostPerUnit())
				.gross_amount(transaction.getGrossAmount())
				.id(transaction.getId())
				.net_amount(transaction.getNetAmount())
				.swapId(transaction.getSwap() == null ? null : transaction.getSwap().getId())
				.transactionDate(transaction.getTransactionDate())
				.units(transaction.getUnits())
				.build();
	}
	
	/**
	 * This method casts the {@link TransactionDto} class to its {@link Transaction} entity class
	 * @return {@link Transaction}
	 */
	
	private Transaction getEntity(TransactionDto dto) throws Exception {
		
		Swap swap = swapRepository.findById(dto.getSwapId())
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		return Transaction.builder()
				.charges(dto.getCharges())
				.costPerUnit(dto.getCost_per_unit())
				.grossAmount(dto.getGross_amount())
				.id(dto.getId())
				.netAmount(dto.getNet_amount())
				.transactionDate(dto.getTransactionDate())
				.units(dto.getUnits())
				.swap(swap)
				.build();
	}
	
}
