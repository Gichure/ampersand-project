package com.pgichure.ampersand.setups.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.DriverDto;
import com.pgichure.ampersand.setups.repositories.DriverRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The Driver service class implementation
 */
@Service
@RequiredArgsConstructor
public class DriverService implements DriverServiceI{
	
	private final DriverRepository repository;

	@Override
	public DriverDto save(DriverDto driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto update(DriverDto driver, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DriverDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
