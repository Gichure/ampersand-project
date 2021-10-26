package com.pgichure.ampersand.setups.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.models.Swap;
import com.pgichure.ampersand.operations.models.Transaction;
import com.pgichure.ampersand.operations.repositories.SwapRepository;
import com.pgichure.ampersand.operations.repositories.TransactionRepository;
import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.models.CostSetup;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.setups.repositories.BatteryRepository;
import com.pgichure.ampersand.setups.repositories.DriverRepository;
import com.pgichure.ampersand.setups.repositories.MotorCycleRepository;
import com.pgichure.ampersand.setups.repositories.StationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 * <p> The implementation of the battery service
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BatteryService implements BatteryServiceI{
	
	private final BatteryRepository repository;
	
	private final StationRepository stationRepository;
	
	private final DriverRepository driverRepository;
	
	private final SwapRepository swapRepository;
	
	private final MotorCycleRepository motorCycleRepository;
	
	private final TransactionRepository transactionRepository;
	
	private final CostSetupServiceI costSetupService;

	@Override
	public BatteryDto save(BatteryDto dto) throws Exception{
		Battery battery = this.getEntity(dto);
		battery = repository.save(battery);
		return this.getDto(battery);
	}

	@Override
	public BatteryDto update(BatteryDto dto, Long id) throws Exception{
		
		Battery battery = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		battery = this.getEntity(dto);
		battery = repository.save(battery);
		
		return this.getDto(battery);
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
		return this.getDto(battery);
	}

	@Override
	public List<BatteryDto> findAll() {
		List<Battery> batteries = repository.findAll();
		return batteries.stream().map(battery -> this.getDto(battery))
                .collect(Collectors.toList());
	}

	@Override
	public BatteryDto swap(Long batteryId, SwapDto dto) throws Exception {
		
		Battery battery = repository.findById(batteryId)
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
		log.info("battery: "+battery.getBatteryType());
		Station station = stationRepository.findById(dto.getStation_id())
				.orElseThrow(()-> new Exception("Station Resource not found for the ID provided"));
		log.info("station: "+station.getName());
		MotorCycle cycle = motorCycleRepository.findById(dto.getBike_id())
				.orElseThrow(()-> new Exception("Motor cycle Resource not found for the ID provided"));
		
		log.info("cycle: "+cycle.getChassisNumber());
		CostSetup costSetup = costSetupService.findAllAsAt(new Date());
		
		if(costSetup != null) {
			log.info("costSetup: "+costSetup.getCostPerUnit());
			Swap swap = Swap.builder()
					.batteryIssued(battery)
					.chargeIssueLevel(dto.getCharge_issue_level())
					.chargeReturnLevel(dto.getCharge_return_level())
					.dateReturned(dto.getDate_returned())
					.returnMileage(dto.getReturn_mileage())
					.issuanceMileage(dto.getIssuance_mileage())
					.station(station)
					.issuedTo(cycle)
					.dateIssued(new Date())
					.build();
			swap = swapRepository.save(swap);
			
			BigDecimal units = swap.getChargeIssueLevel().subtract(swap.getChargeReturnLevel() == null ? BigDecimal.ZERO : swap.getChargeReturnLevel());
			BigDecimal grossAmmount = costSetup.getCostPerUnit().multiply(units);
			
			Transaction transaction = Transaction.builder()
					.charges(costSetup.getApplicableCharges())
					.costPerUnit(costSetup.getCostPerUnit())
					.grossAmount(grossAmmount)
					.netAmount(grossAmmount.subtract(costSetup.getApplicableCharges()))
					.swap(swap)
					.transactionDate(swap.getDateIssued())
					.units(units)
					.build();
			
			transaction = transactionRepository.save(transaction);
			battery.setMotorCycle(cycle);
			battery = repository.save(battery);
		}else
			throw new Exception("You do not have current cost setups.");
		
		return this.getDto(battery);
	}

	@Override
	public BatteryDto allocate(Long cycleId, Long batteryId) throws Exception{
		
		Battery battery = repository.findById(batteryId)
				.orElseThrow(()-> new Exception("Battery Resource not found for the ID provided"));
		
		MotorCycle motorCycle = motorCycleRepository.findById(cycleId)
				.orElseThrow(()-> new Exception("Motor Cycle Resource not found for the ID provided"));
		
		battery.setMotorCycle(motorCycle);
		battery = repository.save(battery);
		
		return this.getDto(battery);
	}
	
	/**
	 * This method casts the {@link Battery} entity class to its {@link BatteryDto}
	 * @return {@link BatteryDto}
	 */
	private BatteryDto getDto(Battery battery) {
		return BatteryDto.builder()
				.battery_type(battery.getBatteryType())
				.capacity(battery.getCapacity())
				.id(battery.getId())
				.serial_number(battery.getSerialNumber())
				.motor_cycle_id(battery.getMotorCycle() ==  null ? null : battery.getMotorCycle().getId())
				.build();
	}
	
	/**
	 * This method casts the {@link BatteryDto} class to its {@link Battery} entity class
	 * @return {@link Battery}
	 */
	private Battery getEntity(BatteryDto dto) throws Exception{
		
		Battery battery = Battery.builder()
					.batteryType(dto.getBattery_type())
					.capacity(dto.getCapacity())
					.id(dto.getId())
					.serialNumber(dto.getSerial_number())
					.build();
		
		if(dto.getMotor_cycle_id() != null) {
			
			MotorCycle motorCycle = motorCycleRepository.findById(dto.getMotor_cycle_id())
					.orElseThrow(()-> new Exception("Motor Cycle Resource not found for the ID provided"));
			battery.setMotorCycle(motorCycle);
		}
		
		return battery;
	}

}
