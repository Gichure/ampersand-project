package com.pgichure.ampersand.setups.controllers;

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

import com.pgichure.ampersand.setups.dtos.DriverDto;
import com.pgichure.ampersand.setups.dtos.DriverResponseDto;
import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.setups.services.DriverServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>The endpoint controller class for the {@link Driver} class
 */

@RestController
@RequestMapping(value = "/drivers")
@Api(tags = {"System Setups"}, description = "Operations relations system setups")
@RequiredArgsConstructor
public class DriverController {

	private final DriverServiceI service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a driver", notes = "Returns saved driver details.",response = DriverDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the driver."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<DriverDto> save(
			@ApiParam(value = "The driver details.", required = true)
			@RequestBody DriverDto driver) {
		try {
			driver = service.save(driver);
			return new ResponseEntity<DriverDto>(driver, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<DriverDto>(driver, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch driver using ID", response = DriverDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<DriverDto> findById(
			@ApiParam(value = "The ID of the driver to query.", required = true)
			@PathVariable("id") Long id) {
		DriverDto driver = DriverDto.builder()
				.build();
		try {
			driver = service.findById(id);
			return new ResponseEntity<DriverDto>(driver, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<DriverDto>(driver, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<DriverDto>(driver, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch drivers values listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<DriverDto>> findByAll() {
		List<DriverDto> drivers = new ArrayList<DriverDto>();
		try {
			drivers = service.findAll();
			return new ResponseEntity<List<DriverDto>>(drivers, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<DriverDto>>(drivers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}/consumption")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch driver's consumption using ID", response = DriverResponseDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<DriverResponseDto> findConsumptionById(
			@ApiParam(value = "The ID of the driver to query.", required = true)
			@PathVariable("id") Long id) {
		DriverResponseDto driver = DriverResponseDto.builder()
				.build();
		try {
			driver = service.getTotalConsumption(id);
			return new ResponseEntity<DriverResponseDto>(driver, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<DriverResponseDto>(driver, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<DriverResponseDto>(driver, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update driver using ID", response = DriverDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<DriverDto> update(
			@ApiParam(value = "The ID of the driver to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The driver details.", required = true)
			@RequestBody DriverDto driver) {
		try {
			driver = service.update(driver, id);
			return new ResponseEntity<DriverDto>(driver, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<DriverDto>(driver, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DriverDto>(driver, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete driver using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<DriverDto> deleteById(
			@ApiParam(value = "The ID of the driver to delete.", required = true)
			@PathVariable("id") Long id) {
		DriverDto driver = DriverDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<DriverDto>(driver, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<DriverDto>(driver, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
