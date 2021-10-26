package com.pgichure.ampersand.operations.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.operations.models.Swap;

/**
 * @author Paul
 * <p>{@link Swap} data access object
 */
public interface SwapRepository extends JpaRepository<Swap, Long>{
	
	public List<Swap> findAllByIssuedToId(Long driverId);

}
