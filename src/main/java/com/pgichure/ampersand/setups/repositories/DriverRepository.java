package com.pgichure.ampersand.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.setups.models.Driver;

/**
 * @author Paul
 * <p> @Driver data access object
 */
public interface DriverRepository extends JpaRepository<Driver, Long>{

}
