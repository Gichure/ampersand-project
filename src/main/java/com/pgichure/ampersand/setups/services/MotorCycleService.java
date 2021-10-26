package com.pgichure.ampersand.setups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.setups.dtos.DriverDto;
import com.pgichure.ampersand.setups.dtos.MotorCycleDto;
import com.pgichure.ampersand.setups.dtos.MotorCycleResponseDto;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.repositories.BatteryRepository;
import com.pgichure.ampersand.setups.repositories.DriverRepository;
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
	
	private final DriverRepository driverRepository;
	
	private final BatteryRepository batteryRepository;

	@Override
	public MotorCycleDto save(MotorCycleDto motorCycle) throws Exception{
		MotorCycle cycle =  this.getEntity(motorCycle);
		cycle = repository.save(cycle);
		return this.getDto(cycle);
	}

	@Override
	public MotorCycleDto update(MotorCycleDto motorCycle, Long id) throws Exception {
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		cycle = this.getEntity(motorCycle);
		
		if(motorCycle.getDriverId() != null) {
			Driver driver = driverRepository.findById(motorCycle.getDriverId())
				.orElseThrow(()-> new Exception("Driver Resource not found for the ID provided"));
			cycle.setIssuedTo(driver);
		}
		
		if(motorCycle.getBatteryId() != null) {
			Battery battery = batteryRepository.findById(motorCycle.getBatteryId())
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
			cycle.setCurrentBattery(battery);
		}
		
		cycle = repository.save(cycle);
		return this.getDto(cycle);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		repository.delete(cycle);
	}

	@Override
	public MotorCycleResponseDto findById(Long id) throws Exception {
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		return this.getResponseDto(cycle);
	}

	@Override
	public List<MotorCycleResponseDto> findAll() throws Exception{
		List<MotorCycle> cycles = repository.findAll();
		return cycles.stream().map(cycle -> this.getResponseDto(cycle))
                .collect(Collectors.toList());
	}

	@Override
	public MotorCycleDto assign(MotorCycleDto motorCycle, Long id) throws Exception{
		MotorCycle cycle = repository.findById(id)
				.orElseThrow(()-> new Exception("Motor Cycle Resource not found for the ID provided"));
		
		cycle.setChassisNumber(motorCycle.getChassisNumber());
		cycle.setColour(motorCycle.getColour());
		cycle.setMake(motorCycle.getMake());
		cycle.setModel(motorCycle.getModel());
		
		if(motorCycle.getDriverId() != null) {
			Driver driver = driverRepository.findById(motorCycle.getDriverId())
				.orElseThrow(()-> new Exception("Driver Resource not found for the ID provided"));
			cycle.setIssuedTo(driver);
		}
		
		if(motorCycle.getBatteryId() != null) {
			Battery battery = batteryRepository.findById(motorCycle.getBatteryId())
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
			cycle.setCurrentBattery(battery);
		}
		
		cycle = repository.save(cycle);
		
		return this.getDto(cycle);
	}

	/**
	 * This method casts the {@link MotorCycleDto} class to its {@link MotorCycle} entity class
	 * @return {@link MotorCycle}
	 */
	
	private MotorCycle getEntity(MotorCycleDto dto) throws Exception {
		MotorCycle cycle = MotorCycle.builder()
			.id(dto.getId())
			.chassisNumber(dto.getChassisNumber())
			.colour(dto.getColour())
			.make(dto.getMake())
			.model(dto.getModel())
			.build();
		
		if(dto.getDriverId() != null) {
			Driver driver = driverRepository.findById(dto.getDriverId())
				.orElseThrow(()-> new Exception("Driver Resource not found for the ID provided"));
			cycle.setIssuedTo(driver);
		}
		
		if(dto.getBatteryId() != null) {
			Battery battery = batteryRepository.findById(dto.getBatteryId())
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
			cycle.setCurrentBattery(battery);
		}
		
		return cycle;
	}
	
	/**
	 * This method casts the {@link MotorCycle} entity class to its {@link MotorCycleDto}
	 * @return {@link MotorCycleDto}
	 */
	private MotorCycleDto getDto(MotorCycle cycle) {
		return MotorCycleDto.builder()
				.id(cycle.getId())
				.chassisNumber(cycle.getChassisNumber())
				.colour(cycle.getColour())
				.batteryId(cycle.getCurrentBattery() == null ? null : cycle.getCurrentBattery().getId())
				.driverId(cycle.getIssuedTo() == null ? null : cycle.getIssuedTo().getId())
				.make(cycle.getMake())
				.model(cycle.getModel())
				.build();
	}
	
	/**
	 * This method casts the {@link MotorCycle} entity class to its {@link MotorCycleDto}
	 * @return {@link MotorCycleDto}
	 */
	private MotorCycleResponseDto getResponseDto(MotorCycle cycle) {
		
		return MotorCycleResponseDto.builder()
				.id(cycle.getId())
				.chassisNumber(cycle.getChassisNumber())
				.colour(cycle.getColour())
				.battery(cycle.getCurrentBattery() == null ? null : 
					BatteryDto.builder()
					.battery_type(cycle.getCurrentBattery().getBatteryType())
					.capacity(cycle.getCurrentBattery().getCapacity())
					.id(cycle.getCurrentBattery().getId())
					.serial_number(cycle.getCurrentBattery().getSerialNumber())
					.build())
				.driver(cycle.getIssuedTo() == null ? null : 
					DriverDto.builder()
					.id(cycle.getIssuedTo().getId())
					.identification_number(cycle.getIssuedTo().getIdNumber())
					.license_number(cycle.getIssuedTo().getLicenseNumber())
					.locality(cycle.getIssuedTo().getLocality())
					.name(cycle.getIssuedTo().getName())
					.town(cycle.getIssuedTo().getTown())
					.build())
				.make(cycle.getMake())
				.model(cycle.getModel())
				.build();
	}
}
