package com.pgichure.ampersand.operations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.ampersand.operations.models.SwappingLog;

/**
 * @author Paul
 * <p> @SwappingLog data access object
 */
public interface SwappingLogRepository extends JpaRepository<SwappingLog, Long>{

}
