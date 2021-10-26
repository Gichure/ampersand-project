package com.pgichure.ampersand.setups.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.setups.repositories.BatteryRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The implementation of the battery service
 */

@Service
@RequiredArgsConstructor
public class BatteryService implements BatteryServiceI{
	
	private final BatteryRepository repository;

	@Override
	public BatteryDto save(BatteryDto battery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatteryDto update(BatteryDto battery, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BatteryDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BatteryDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
