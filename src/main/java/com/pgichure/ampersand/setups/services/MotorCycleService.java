package com.pgichure.ampersand.setups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.MotorCycleDto;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.repositories.MotorCycleRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The {@link MotorCycle} service class implementation
 */
@Service
@RequiredArgsConstructor
public class MotorCycleService implements MotorCycleServiceI{
	
	private final MotorCycleRepository repository;

	@Override
	public MotorCycleDto save(MotorCycleDto motorCycle) {
		MotorCycle cycle =  motorCycle.getEntity();
		cycle = repository.save(cycle);
		return cycle.getDto();
	}

	@Override
	public MotorCycleDto update(MotorCycleDto motorCycle, Long id) throws Exception {
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		cycle = motorCycle.getEntity();
		cycle = repository.save(cycle);
		return cycle.getDto();
	}

	@Override
	public void deleteById(Long id) throws Exception {
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
	}

	@Override
	public MotorCycleDto findById(Long id) throws Exception {
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		return cycle.getDto();
	}

	@Override
	public List<MotorCycleDto> findAll() {
		List<MotorCycle> cycles = repository.findAll();
		return cycles.stream().map(cycle -> cycle.getDto())
                .collect(Collectors.toList());
	}

	
}
