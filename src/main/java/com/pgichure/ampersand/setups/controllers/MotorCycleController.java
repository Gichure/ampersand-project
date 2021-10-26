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

import com.pgichure.ampersand.setups.dtos.MotorCycleDto;
import com.pgichure.ampersand.setups.dtos.MotorCycleResponseDto;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.services.MotorCycleServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>The endpoint controller class for the {@link MotorCycle} class
 */
@RestController
@RequestMapping(value = "/motor-cycles")
@Api(tags = {"System Setups"}, description = "Operations relations system setups")
@RequiredArgsConstructor
public class MotorCycleController {
	
	private final MotorCycleServiceI service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a motor cycle", notes = "Returns saved motor cycle details.",response = MotorCycleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the motor cycle."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<MotorCycleDto> save(
			@ApiParam(value = "The motor cycle details.", required = true)
			@RequestBody MotorCycleDto motorCycle) {
		try {
			motorCycle = service.save(motorCycle);
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Assign of a motor cycle to a driver", notes = "Returns assigned motor cycle details.",response = MotorCycleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully assigned the motor cycle."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<MotorCycleDto> assign(
			@ApiParam(value = "The assignment details.", required = true)
			@RequestBody MotorCycleDto motorCycle,
			@ApiParam(value = "The ID of the motor cycle to assign.", required = true)
			@PathVariable("id") Long id) {
		try {
			motorCycle = service.assign(motorCycle, id);
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch motor cycle using ID", response = MotorCycleResponseDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<MotorCycleResponseDto> findById(
			@ApiParam(value = "The ID of the motor cycle to query.", required = true)
			@PathVariable("id") Long id) {
		MotorCycleResponseDto motorCycle = MotorCycleResponseDto.builder()
				.build();
		try {
			motorCycle = service.findById(id);
			return new ResponseEntity<MotorCycleResponseDto>(motorCycle, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<MotorCycleResponseDto>(motorCycle, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<MotorCycleResponseDto>(motorCycle, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch cycles values listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<MotorCycleResponseDto>> findByAll() {
		List<MotorCycleResponseDto> cycles = new ArrayList<MotorCycleResponseDto>();
		try {
			cycles = service.findAll();
			return new ResponseEntity<List<MotorCycleResponseDto>>(cycles, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MotorCycleResponseDto>>(cycles, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update motor cycle using ID", response = MotorCycleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<MotorCycleDto> update(
			@ApiParam(value = "The ID of the motor cycle to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The motor cycle details.", required = true)
			@RequestBody MotorCycleDto motorCycle) {
		try {
			motorCycle = service.update(motorCycle, id);
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete motor cycle using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<MotorCycleDto> deleteById(
			@ApiParam(value = "The ID of the motor cycle to delete.", required = true)
			@PathVariable("id") Long id) {
		MotorCycleDto motorCycle = MotorCycleDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<MotorCycleDto>(motorCycle, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
