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

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.models.Swap;
import com.pgichure.ampersand.operations.services.SwapServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 *<p>The endpoint controller class for the {@link Swap} class
 */
@RestController
@RequestMapping(value = "/swaps")
@Api(tags = {"Operations & Trasactions"}, description = "Operations and System Transactions")
@RequiredArgsConstructor
public class SwapController {
	
	private final SwapServiceI service;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a swap", notes = "Returns saved swap details.",response = SwapDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the swap."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<SwapDto> save(
			@ApiParam(value = "The swap details.", required = true)
			@RequestBody SwapDto swap) {
		try {
			swap = service.save(swap);
			return new ResponseEntity<SwapDto>(swap, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<SwapDto>(swap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch swap using ID", response = SwapDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<SwapDto> findById(
			@ApiParam(value = "The ID of the swap to query.", required = true)
			@PathVariable("id") Long id) {
		SwapDto swap = SwapDto.builder()
				.build();
		try {
			swap = service.findById(id);
			return new ResponseEntity<SwapDto>(swap, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<SwapDto>(swap, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<SwapDto>(swap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch swaps values listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<SwapDto>> findByAll() {
		List<SwapDto> swaps = new ArrayList<SwapDto>();
		try {
			swaps = service.findAll();
			return new ResponseEntity<List<SwapDto>>(swaps, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<SwapDto>>(swaps, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update swap using ID", response = SwapDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<SwapDto> update(
			@ApiParam(value = "The ID of the swap to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The swap details.", required = true)
			@RequestBody SwapDto swap) {
		try {
			swap = service.update(swap, id);
			return new ResponseEntity<SwapDto>(swap, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<SwapDto>(swap, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<SwapDto>(swap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete swap using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<SwapDto> deleteById(
			@ApiParam(value = "The ID of the swap to delete.", required = true)
			@PathVariable("id") Long id) {
		SwapDto swap = SwapDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<SwapDto>(swap, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<SwapDto>(swap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
