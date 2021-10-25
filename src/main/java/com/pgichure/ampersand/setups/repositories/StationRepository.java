package com.pgichure.ampersand.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.setups.models.Station;

/**
 * @author Paul
 * <p> @Station data access object
 */
public interface StationRepository extends JpaRepository<Station, Long>{

}
