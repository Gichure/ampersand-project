package com.pgichure.ampersand.setups.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pgichure.ampersand.setups.dtos.MotorCycleDto;
import com.pgichure.ampersand.utils.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is the entity class for a motor cycle
 */
@Data
@RequiredArgsConstructor
@Table(name ="tbl_motor_cycles")
@EqualsAndHashCode(callSuper=false)
@Entity
@Builder
@AllArgsConstructor
public class MotorCycle extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cycle_id", nullable = false)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver issuedTo;
	
	@Column(name = "make", nullable = false)
    private String make;
	
	@Column(name = "model", nullable = false)
    private String model;
	
	@Column(name = "colour", nullable = false)
    private String colour;
	
	@Column(name = "chassis_number", nullable = false)
    private String chassisNumber;
	
	/**
	 * This method casts the {@link MotorCycle} entity class to its {@link MotorCycleDto}
	 * @return {@link MotorCycleDto}
	 */
	public MotorCycleDto getDto() {
		return MotorCycleDto.builder()
				.id(this.getId())
				.chassisNumber(this.getChassisNumber())
				.colour(this.getColour())
				.driverId(this.getIssuedTo() == null ? null : this.getIssuedTo().getId())
				.make(this.getMake())
				.model(this.getModel())
				.build();
	}
	
}
