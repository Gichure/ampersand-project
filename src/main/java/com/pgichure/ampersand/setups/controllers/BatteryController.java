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

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.services.BatteryServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The endpoint controller class for the {@link Battery} class
 */
@RestController
@RequestMapping(value = "/batteries")
@Api(tags = {"System Setups"}, description = "Operations relations system setups")
@RequiredArgsConstructor
public class BatteryController {
	
	private final BatteryServiceI service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a battery", notes = "Returns saved battery details.",response = BatteryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the battery."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<BatteryDto> save(
			@ApiParam(value = "The battery details.", required = true)
			@RequestBody BatteryDto battery) {
		try {
			battery = service.save(battery);
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a swap", notes = "Returns saved swap details.",response = BatteryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully swapped the battery."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<BatteryDto> swap(
			@ApiParam(value = "The swapping details.", required = true)
			@RequestBody SwapDto swap,
			@ApiParam(value = "The ID of the motor bike", required = true)
			@PathVariable("id") Long id) {
		BatteryDto battery = BatteryDto.builder().build();
		try {
			battery = service.swap(id, swap);
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/{id}/allocate/{cycleId}")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Initial assigning to a motor cycle", notes = "Returns saved swap details.",response = BatteryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully assigned the battery."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<BatteryDto> assign(
			@ApiParam(value = "The ID of the battery to assign.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The ID of the motor cycle to assign to.", required = true)
			@PathVariable("cycleId") Long cycleId) {
		BatteryDto battery = BatteryDto.builder().build();
		try {
			battery = service.allocate(cycleId, id);
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch battery using ID", response = BatteryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<BatteryDto> findById(
			@ApiParam(value = "The ID of the battery to query.", required = true)
			@PathVariable("id") Long id) {
		BatteryDto battery = BatteryDto.builder()
				.build();
		try {
			battery = service.findById(id);
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch batteries values listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<BatteryDto>> findByAll() {
		List<BatteryDto> batteries = new ArrayList<BatteryDto>();
		try {
			batteries = service.findAll();
			return new ResponseEntity<List<BatteryDto>>(batteries, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<BatteryDto>>(batteries, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update battery using ID", response = BatteryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<BatteryDto> update(
			@ApiParam(value = "The ID of the battery to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The battery details.", required = true)
			@RequestBody BatteryDto battery) {
		try {
			battery = service.update(battery, id);
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete battery using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<BatteryDto> deleteById(
			@ApiParam(value = "The ID of the battery to delete.", required = true)
			@PathVariable("id") Long id) {
		BatteryDto battery = BatteryDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<BatteryDto>(battery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
