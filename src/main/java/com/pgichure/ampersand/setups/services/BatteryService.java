package com.pgichure.ampersand.setups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.setups.models.Battery;
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
	public BatteryDto save(BatteryDto dto) {
		Battery battery = dto.getEntity();
		battery = repository.save(battery);
		return battery.getDto();
	}

	@Override
	public BatteryDto update(BatteryDto dto, Long id) throws Exception{
		Battery battery = repository.findById(id)
		.orElseThrow(()-> new Exception("Resource not found for the ID provided"));

		battery = dto.getEntity();
		battery = repository.save(battery);
		
		return battery.getDto();
	}

	@Override
	public void deleteById(Long id)  throws Exception{
		Battery battery = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
				repository.delete(battery);
		repository.delete(battery);
	}

	@Override
	public BatteryDto findById(Long id)  throws Exception{
		Battery battery = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
				repository.delete(battery);
		return battery.getDto();
	}

	@Override
	public List<BatteryDto> findAll() {
		List<Battery> batteries = repository.findAll();
		return batteries.stream().map(battery -> battery.getDto())
                .collect(Collectors.toList());
	}

}
