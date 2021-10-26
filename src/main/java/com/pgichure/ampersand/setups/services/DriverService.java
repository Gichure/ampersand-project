package com.pgichure.ampersand.setups.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.services.SwapServiceI;
import com.pgichure.ampersand.setups.dtos.DriverDto;
import com.pgichure.ampersand.setups.dtos.DriverResponseDto;
import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.repositories.DriverRepository;
import com.pgichure.ampersand.setups.repositories.MotorCycleRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The {@link Driver} service class implementation
 */
@Service
@RequiredArgsConstructor
public class DriverService implements DriverServiceI{
	
	private final DriverRepository repository;
	
	private final SwapServiceI swapService;
	
	private final MotorCycleRepository motorCycleRepository;

	@Override
	public DriverDto save(DriverDto dto) {
		Driver driver = this.getEntity(dto);
		driver = repository.save(driver);
		return this.getDto(driver);
	}

	@Override
	public DriverDto update(DriverDto dto, Long id) throws Exception{
		Driver driver = repository.findById(id).orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		driver = this.getEntity(dto);
		return this.getDto(driver);
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
		return this.getDto(driver);
	}

	@Override
	public List<DriverDto> findAll() {
		List<Driver> drivers = repository.findAll();
		return drivers.stream().map(driver -> this.getDto(driver))
                .collect(Collectors.toList());
	}

	/**
	 * This method casts the {@link Driver} entity class to its {@link DriverDto}
	 * @return {@link DriverDto}
	 */
	private DriverDto getDto(Driver driver) {
		return DriverDto.builder()
				.id(driver.getId())
				.identification_number(driver.getIdNumber())
				.license_number(driver.getLicenseNumber())
				.locality(driver.getLocality())
				.name(driver.getName())
				.town(driver.getTown())
				.build();
	}
	
	/**
	 * This method casts the {@link DriverDto} class to its {@link Driver} entity class
	 * @return {@link Driver}
	 */
	private Driver getEntity(DriverDto dto) {
		
		return Driver.builder()
				.id(dto.getId())
				.idNumber(dto.getIdentification_number())
				.licenseNumber(dto.getLicense_number())
				.locality(dto.getLocality())
				.name(dto.getName())
				.town(dto.getTown())
				.build();
	}

	@Override
	public DriverResponseDto getTotalConsumption(Long id) throws Exception {
		
		Driver driver = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		MotorCycle motorCycle = motorCycleRepository.findByIssuedToId(id); 
		
		List<SwapDto> swaps = new ArrayList<SwapDto>();
		
		BigDecimal total = BigDecimal.ZERO;
		
		if(motorCycle != null) {
			swaps = swapService.findAllByIssuedToId(motorCycle.getId());
		
			total = swapService.getTotalConsumptionByIssuedToId(motorCycle.getId());
		}
		
		return DriverResponseDto.builder()
				.id(driver.getId())
				.identification_number(driver.getIdNumber())
				.license_number(driver.getLicenseNumber())
				.locality(driver.getLocality())
				.name(driver.getName())
				.town(driver.getTown())
				.swaps(swaps)
				.total_consumption(total)
				.build();
	}
	
}
