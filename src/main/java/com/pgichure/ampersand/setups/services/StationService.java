package com.pgichure.ampersand.setups.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.StationDto;
import com.pgichure.ampersand.setups.repositories.StationRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The Station service class implementation
 */
@Service
@RequiredArgsConstructor
public class StationService implements StationServiceI{
	
	private final StationRepository repository;

	@Override
	public StationDto save(StationDto station) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StationDto update(StationDto station, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StationDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StationDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
