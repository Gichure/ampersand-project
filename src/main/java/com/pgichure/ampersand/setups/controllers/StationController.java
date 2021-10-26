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

import com.pgichure.ampersand.setups.dtos.StationDto;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.setups.services.StationServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 *<p>The endpoint controller class for the {@link Station} class
 */
@Slf4j
@RestController
@RequestMapping(value = "/stations")
@Api(tags = {"System Setups"}, description = "Operations relations system setups")
@RequiredArgsConstructor
public class StationController {

	private final StationServiceI service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Saving of a station", notes = "Returns saved station details.",response = StationDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created the station."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<StationDto> save(
			@ApiParam(value = "The station details.", required = true)
			@RequestBody StationDto station) {
		try {
			station = service.save(station);
			return new ResponseEntity<StationDto>(station, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<StationDto>(station, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Fetch station using ID", response = StationDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<StationDto> findById(
			@ApiParam(value = "The ID of the station to query.", required = true)
			@PathVariable("id") Long id) {
		StationDto station = StationDto.builder()
				.build();
		try {
			station = service.findById(id);
			return new ResponseEntity<StationDto>(station, HttpStatus.FOUND);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<StationDto>(station, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<StationDto>(station, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	@ApiOperation(value = "Fetch stations listing", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the records"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<List<StationDto>> findByAll() {
		List<StationDto> stations = new ArrayList<StationDto>();
		try {
			stations = service.findAll();
			return new ResponseEntity<List<StationDto>>(stations, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<StationDto>>(stations, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Update station using ID", response = StationDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<StationDto> update(
			@ApiParam(value = "The ID of the station to update.", required = true)
			@PathVariable("id") Long id,
			@ApiParam(value = "The station details.", required = true)
			@RequestBody StationDto station) {
		try {
			station = service.update(station, id);
			return new ResponseEntity<StationDto>(station, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<StationDto>(station, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<StationDto>(station, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete station using ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the record"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The server encountered an error")
	})
	public ResponseEntity<StationDto> deleteById(
			@ApiParam(value = "The ID of the station to delete.", required = true)
			@PathVariable("id") Long id) {
		StationDto station = StationDto.builder()
				.build();
		try {
			service.deleteById(id);
			return new ResponseEntity<StationDto>(station, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<StationDto>(station, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
