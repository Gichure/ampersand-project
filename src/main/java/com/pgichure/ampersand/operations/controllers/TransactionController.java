package com.pgichure.ampersand.operations.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pgichure.ampersand.operations.dtos.TransactionDto;
import com.pgichure.ampersand.operations.models.Transaction;
import com.pgichure.ampersand.operations.services.TransactionServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 *<p>The endpoint controller class for the {@link Transaction} class
 */
@RestController
@RequestMapping(value = "/transactions")
@Api(tags = {"Operations & Trasactions"}, description = "Operations and System Transactions")
@RequiredArgsConstructor
public class TransactionController {
	
	private final TransactionServiceI service;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a transaction", notes = "Returns saved transaction details.",response = TransactionDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the transaction."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<TransactionDto> save(
			@ApiParam(value = "The transaction details.", required = true)
			@RequestBody TransactionDto transaction) {
		try {
			transaction = service.save(transaction);
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch transaction using ID", response = TransactionDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<TransactionDto> findById(
			@ApiParam(value = "The ID of the transaction to query.", required = true)
			@PathVariable("id") Long id) {
		TransactionDto transaction = TransactionDto.builder()
				.build();
		try {
			transaction = service.findById(id);
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch transactions values listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<TransactionDto>> findByAll() {
		List<TransactionDto> transactions = new ArrayList<TransactionDto>();
		try {
			transactions = service.findAll();
			return new ResponseEntity<List<TransactionDto>>(transactions, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<TransactionDto>>(transactions, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update transaction using ID", response = TransactionDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<TransactionDto> update(
			@ApiParam(value = "The ID of the transaction to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The transaction details.", required = true)
			@RequestBody TransactionDto transaction) {
		try {
			transaction = service.update(transaction, id);
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete transaction using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<TransactionDto> deleteById(
			@ApiParam(value = "The ID of the transaction to delete.", required = true)
			@PathVariable("id") Long id) {
		TransactionDto transaction = TransactionDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<TransactionDto>(transaction, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
