package com.pgichure.ampersand.operations.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.operations.repositories.SwapRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>The Swap service class implementation
 */
@Service
@RequiredArgsConstructor
public class SwapService implements SwapServiceI{
	
	private final SwapRepository repository;
	
	@Override
	public SwapDto save(SwapDto swap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SwapDto update(SwapDto swap, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SwapDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SwapDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
