package com.pgichure.ampersand.setups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.StationDto;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.setups.repositories.StationRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The {@link Station} service class implementation
 */
@Service
@RequiredArgsConstructor
public class StationService implements StationServiceI{
	
	private final StationRepository repository;

	@Override
	public StationDto save(StationDto dto) {
		Station station =  dto.getEntity();
		station = repository.save(station);
		return station.getDto();
	}

	@Override
	public StationDto update(StationDto dto, Long id) throws Exception {
		Station station = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		station = dto.getEntity();
		station = repository.save(station);
		return station.getDto();
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
		return station.getDto();
	}

	@Override
	public List<StationDto> findAll() {
		List<Station> stations = repository.findAll();
		return stations.stream().map(station -> station.getDto())
                .collect(Collectors.toList());
	}

}
