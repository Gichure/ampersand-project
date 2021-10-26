package com.pgichure.ampersand.setups.services;

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
		CostSetup setup = dto.getEntity();
		setup = repository.save(setup);
		return setup.getDto();
	}

	@Override
	public CostSetupDto update(CostSetupDto dto, Long id) throws Exception {
		CostSetup setup = repository.findById(id)
				.orElseThrow(()-> new Exception("Resource not found for the ID provided"));
		
		setup = dto.getEntity();
		setup = repository.save(setup);
		return setup.getDto();
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
		return setup.getDto();
	}

	@Override
	public List<CostSetupDto> findAll() {
		List<CostSetup> setups = repository.findAll();
		return setups.stream().map(setup -> setup.getDto())
                .collect(Collectors.toList());
	}

	
}
