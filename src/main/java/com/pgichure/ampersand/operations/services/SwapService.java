package com.pgichure.ampersand.operations.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.models.Swap;
import com.pgichure.ampersand.operations.repositories.SwapRepository;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.setups.repositories.BatteryRepository;
import com.pgichure.ampersand.setups.repositories.DriverRepository;
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
	
	@Override
	public SwapDto save(SwapDto dto) throws Exception{
		
		Station station = stationRepository.findById(dto.getStation_id())
				.orElseThrow(()-> new Exception("Station Resource not found for the ID provided"));
		
		Driver driver = driverRepository.findById(dto.getDriver_id())
				.orElseThrow(()-> new Exception("Driver Resource not found for the ID provided"));
		
		Battery battery = batteryRepository.findById(dto.getBattery_id())
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
		
		Swap swap = dto.getEntity();
		swap.setBatteryIssued(battery);
		swap.setIssuedTo(driver);
		swap.setStation(station);
		swap = repository.save(swap);
		return swap.getDto();
	}

	@Override
	public SwapDto update(SwapDto dto, Long id) throws Exception{
		
		Station station = stationRepository.findById(id)
				.orElseThrow(()-> new Exception("Station Resource not found for the ID provided"));
		
		Driver driver = driverRepository.findById(id)
				.orElseThrow(()-> new Exception("Driver Resource not found for the ID provided"));
		
		Battery battery = batteryRepository.findById(id)
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
		
		Swap swap = repository.findById(id)
				.orElseThrow(()-> new Exception("Swap Resource not found for the ID provided"));
		swap = dto.getEntity();
		swap.setBatteryIssued(battery);
		swap.setIssuedTo(driver);
		swap.setStation(station);
		swap = repository.save(swap);
		return swap.getDto();
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
		return swap.getDto();
	}

	@Override
	public List<SwapDto> findAll() {
		List<Swap> swaps = repository.findAll();
		return swaps.stream().map(swap -> swap.getDto())
                .collect(Collectors.toList());
	}

	
}
