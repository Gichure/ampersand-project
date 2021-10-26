package com.pgichure.ampersand.setups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.DriverDto;
import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.setups.repositories.DriverRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The {@link Driver} service class implementation
 */
@Service
@RequiredArgsConstructor
public class DriverService implements DriverServiceI{
	
	private final DriverRepository repository;

	@Override
	public DriverDto save(DriverDto dto) {
		Driver driver = dto.getEntity();
		driver = repository.save(driver);
		return driver.getDto();
	}

	@Override
	public DriverDto update(DriverDto dto, Long id) throws Exception{
		Driver driver = repository.findById(id).orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		driver = dto.getEntity();
		
		return driver.getDto();
	}

	@Override
	public void deleteById(Long id) throws Exception{
		Driver driver = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		repository.delete(driver);
	}

	@Override
	public DriverDto findById(Long id) throws Exception{
		Driver driver = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		return driver.getDto();
	}

	@Override
	public List<DriverDto> findAll() {
		List<Driver> drivers = repository.findAll();
		return drivers.stream().map(driver -> driver.getDto())
                .collect(Collectors.toList());
	}

	
}
