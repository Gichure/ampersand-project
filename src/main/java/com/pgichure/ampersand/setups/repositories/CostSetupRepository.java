package com.pgichure.ampersand.setups.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.setups.models.CostSetup;

/**
 * @author Paul
 * <p> {@link CostSetup} data access object
 */
public interface CostSetupRepository extends JpaRepository<CostSetup, Long>{

	public List<CostSetup> findByDateToBefore(Date asAt);
	
}
