package com.pgichure.ampersand.setups.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.setups.dtos.CostSetupDto;
import com.pgichure.ampersand.setups.repositories.CostSetupRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p> The CostSetup service class implementation
 */
@Service
@RequiredArgsConstructor
public class CostSetupService implements CostSetupServiceI{

	private final CostSetupRepository repository;
	
	@Override
	public CostSetupDto save(CostSetupDto setup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CostSetupDto update(CostSetupDto setup, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CostSetupDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostSetupDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
