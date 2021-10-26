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

import com.pgichure.ampersand.setups.dtos.CostSetupDto;
import com.pgichure.ampersand.setups.models.CostSetup;
import com.pgichure.ampersand.setups.services.CostSetupServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
/**
 * @author Paul
 * <p> The endpoint controller class for the {@link CostSetup} class
 */
@RestController
@RequestMapping(value = "/cost-setups")
@Api(tags = {"System Setups"}, description = "Operations relations system setups")
@RequiredArgsConstructor
public class CostSetupController {
	
	private final CostSetupServiceI service;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a cost setup", notes = "Returns saved cost setup details.",response = CostSetupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the setup."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<CostSetupDto> save(
			@ApiParam(value = "The cost setup details.", required = true)
			@RequestBody CostSetupDto setup) {
		try {
			setup = service.save(setup);
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch cost setup using ID", response = CostSetupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<CostSetupDto> findById(
			@ApiParam(value = "The ID of the setup to query.", required = true)
			@PathVariable("id") Long id) {
		CostSetupDto setup = CostSetupDto.builder()
				.build();
		try {
			setup = service.findById(id);
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch setups values listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<CostSetupDto>> findByAll() {
		List<CostSetupDto> setups = new ArrayList<CostSetupDto>();
		try {
			setups = service.findAll();
			return new ResponseEntity<List<CostSetupDto>>(setups, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<CostSetupDto>>(setups, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update setup using ID", response = CostSetupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<CostSetupDto> update(
			@ApiParam(value = "The ID of the cost setup to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The setup details.", required = true)
			@RequestBody CostSetupDto setup) {
		try {
			setup = service.update(setup, id);
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete cost setup using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<CostSetupDto> deleteById(
			@ApiParam(value = "The ID of the cost setup to delete.", required = true)
			@PathVariable("id") Long id) {
		CostSetupDto setup = CostSetupDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<CostSetupDto>(setup, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
