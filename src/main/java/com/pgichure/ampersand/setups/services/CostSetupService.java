package com.pgichure.ampersand.setups.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.CostSetupDto;
import com.pgichure.ampersand.setups.models.CostSetup;
import com.pgichure.ampersand.setups.repositories.CostSetupRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The {@link CostSetup} service class implementation
 */
@Service
@RequiredArgsConstructor
public class CostSetupService implements CostSetupServiceI{

	private final CostSetupRepository repository;
	
	@Override
	public CostSetupDto save(CostSetupDto dto) {
		CostSetup setup = this.getEntity(dto);
		setup = repository.save(setup);
		return this.getDto(setup);
	}

	@Override
	public CostSetupDto update(CostSetupDto dto, Long id) throws Exception {
		CostSetup setup = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		setup = this.getEntity(dto);
		setup = repository.save(setup);
		return this.getDto(setup);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		CostSetup setup = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		repository.delete(setup);
	}

	@Override
	public CostSetupDto findById(Long id) throws Exception {
		CostSetup setup = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		return this.getDto(setup);
	}

	@Override
	public List<CostSetupDto> findAll() {
		List<CostSetup> setups = repository.findAll();
		return setups.stream().map(setup -> this.getDto(setup))
                .collect(Collectors.toList());
	}

	@Override
	public CostSetup findAllAsAt(Date asAt) {
		List<CostSetup> setups = repository.findByDateToBefore(asAt);
		return setups.size() > 0 ? setups.get(0) : null;
	}

	/**
	 * This method casts the {@link CostSetupDto} class to its {@link CostSetup} entity class
	 * @return {@link CostSetup}
	 */
	private CostSetup getEntity(CostSetupDto dto) {
		
		return CostSetup.builder()
				.id(dto.getId())
				.costPerUnit(dto.getCost_per_unit())
				.dateFrom(dto.getDate_from())
				.dateTo(dto.getDate_to())
				.applicableCharges(dto.getCharges())
				.build();
	}
	
	/**
	 * This method casts the {@link CostSetup} entity class to its {@link CostSetupDto}
	 * @return {@link CostSetupDto}
	 */
	private CostSetupDto getDto(CostSetup setup) {
		return CostSetupDto.builder()
				.charges(setup.getApplicableCharges())
				.date_from(setup.getDateFrom())
				.date_to(setup.getDateTo())
				.id(setup.getId())
				.cost_per_unit(setup.getCostPerUnit())
				.build();
	}
}
