package com.pgichure.ampersand.setups.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.MotorCycleDto;
import com.pgichure.ampersand.setups.repositories.MotorCycleRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The MotorCycle service class implementation
 */
@Service
@RequiredArgsConstructor
public class MotorCycleService implements MotorCycleServiceI{
	
	private final MotorCycleRepository repository;

	@Override
	public MotorCycleDto save(MotorCycleDto motorCycle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MotorCycleDto update(MotorCycleDto motorCycle, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MotorCycleDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MotorCycleDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
