package com.pgichure.ampersand.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.setups.models.Battery;

/**
 * @author Paul
 * <p>Battery entity data access object
 */
public interface BatteryRepository extends JpaRepository<Battery, Long>{

}
