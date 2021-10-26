package com.pgichure.ampersand.operations.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.models.Swap;
import com.pgichure.ampersand.operations.repositories.SwapRepository;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.setups.repositories.BatteryRepository;
import com.pgichure.ampersand.setups.repositories.DriverRepository;
import com.pgichure.ampersand.setups.repositories.MotorCycleRepository;
import com.pgichure.ampersand.setups.repositories.StationRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>The {@link Swap} service class implementation
 */
@Service
@RequiredArgsConstructor
public class SwapService implements SwapServiceI{
	
	private final SwapRepository repository;
	
	private final StationRepository stationRepository;
	
	private final DriverRepository driverRepository;
	
	private final BatteryRepository batteryRepository;
	
	private final MotorCycleRepository motorCycleRepository;
	
	@Override
	public SwapDto save(SwapDto dto) throws Exception{
		Swap swap = this.getEntity(dto);
		swap = repository.save(swap);
		return this.getDto(swap);
	}

	@Override
	public SwapDto update(SwapDto dto, Long id) throws Exception{
		Swap swap = repository.findById(id)
				.orElseThrow(()-> new Exception("Swap Resource not found for the ID provided"));
		swap = this.getEntity(dto);
		swap = repository.save(swap);
		return this.getDto(swap);
	}

	@Override
	public void deleteById(Long id) throws Exception{
		Swap swap = repository.findById(id)
				.orElseThrow(()-> new Exception("Swap Resource not found for the ID provided"));
		repository.delete(swap);
	}

	@Override
	public SwapDto findById(Long id) throws Exception{
		Swap swap = repository.findById(id)
				.orElseThrow(()-> new Exception("Swap Resource not found for the ID provided"));
		return this.getDto(swap);
	}

	@Override
	public List<SwapDto> findAll() {
		List<Swap> swaps = repository.findAll();
		return swaps.stream().map(swap -> this.getDto(swap))
                .collect(Collectors.toList());
	}

	/**
	 * This method casts the {@link Swap} entity class to its {@link SwapDto}
	 * @return {@link SwapDto}
	 */
	
	private SwapDto getDto(Swap swap) {
		return SwapDto.builder()
				.charge_issue_level(swap.getChargeIssueLevel())
				.charge_return_level(swap.getChargeReturnLevel())
				.date_issued(swap.getDateIssued())
				.date_returned(swap.getDateReturned())
				.id(swap.getId())
				.issuance_mileage(swap.getIssuanceMileage())
				.return_mileage(swap.getReturnMileage())
				.battery_id(swap.getBatteryIssued() == null ? null : swap.getBatteryIssued().getId())
				.bike_id(swap.getIssuedTo() == null ? null : swap.getIssuedTo().getId())
				.station_id(swap.getStation() == null ? null : swap.getStation().getId())
				.build();
	}
	
	/**
	 * This method casts the {@link SwapDto} class to its {@link Swap} entity class
	 * @return {@link Swap}
	 */
	
	private Swap getEntity(SwapDto dto) throws Exception{
		
		Station station = stationRepository.findById(dto.getStation_id())
				.orElseThrow(()-> new Exception("Station Resource not found for the ID provided"));
		
		MotorCycle cycle = motorCycleRepository.findById(dto.getBike_id())
				.orElseThrow(()-> new Exception("Bike Resource not found for the ID provided"));
		
		Battery battery = batteryRepository.findById(dto.getBattery_id())
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
		
		return Swap.builder()
				.chargeIssueLevel(dto.getCharge_issue_level())
				.chargeReturnLevel(dto.getCharge_return_level())
				.dateIssued(dto.getDate_issued())
				.dateReturned(dto.getDate_returned())
				.id(dto.getId())
				.issuanceMileage(dto.getIssuance_mileage())
				.returnMileage(dto.getReturn_mileage())
				.build();
	}

	@Override
	public List<SwapDto> findAllByIssuedToId(Long driverId) {
		List<Swap> swaps = repository.findAllByIssuedToId(driverId);
		return swaps.stream().map(swap -> this.getDto(swap))
                .collect(Collectors.toList());
	}

	@Override
	public BigDecimal getTotalConsumptionByIssuedToId(Long driverId) {
		List<Swap> swaps = repository.findAllByIssuedToId(driverId);
		BigDecimal total = BigDecimal.ZERO;
		for(Swap swap: swaps) {
			total = total.add(swap.getChargeIssueLevel().subtract(swap.getChargeReturnLevel() == null ? BigDecimal.ZERO : swap.getChargeReturnLevel()));
		}
		return total;
	}
}
