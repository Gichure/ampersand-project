package com.pgichure.ampersand.setups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.StationDto;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.setups.repositories.StationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 * <p> The {@link Station} service class implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StationService implements StationServiceI{
	
	private final StationRepository repository;

	@Override
	public StationDto save(StationDto dto) throws Exception{
		log.info(dto.getBuilding());
		Station station =  this.getEntity(dto);
		log.info(station.getBuilding());
		station = repository.save(station);
		log.info(station.getBuilding());
		return this.getDto(station);
	}

	@Override
	public StationDto update(StationDto dto, Long id) throws Exception {
		Station station = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		station = this.getEntity(dto);
		station = repository.save(station);
		return this.getDto(station);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Station station = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		repository.delete(station);
	}

	@Override
	public StationDto findById(Long id) throws Exception{
		Station station = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		return this.getDto(station);
	}

	@Override
	public List<StationDto> findAll() {
		List<Station> stations = repository.findAll();
		return stations.stream().map(station -> this.getDto(station))
                .collect(Collectors.toList());
	}
	
	/**
	 * This method casts the {@link StationDto} class to its {@link Station} entity class
	 * @return {@link Station}
	 */
	
	private Station getEntity(StationDto dto) {
		return Station.builder()
				.building(dto.getBuilding())
				.coordinates(dto.getCoordinates())
				.id(dto.getId())
				.name(dto.getName())
				.street(dto.getStreet())
				.town(dto.getTown())
				.build();
	}
	
	/**
	 * This method casts the {@link Station} entity class to its {@link StationDto}
	 * @return {@link StationDto}
	 */
	
	private StationDto getDto(Station dto) {
		
		return StationDto.builder()
				.building(dto.getBuilding())
				.coordinates(dto.getCoordinates())
				.id(dto.getId())
				.name(dto.getName())
				.street(dto.getStreet())
				.town(dto.getTown())
				.build();
	}

}
