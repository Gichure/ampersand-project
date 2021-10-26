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
public class MotorCycle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The {@link MotorCycle} unique identifier
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cycle_id", nullable = false)
    private Long id;
	
	/**
	 * The {@link Driver} assigned the motor bike
	 */
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver issuedTo;
	
	/**
	 * The {@link Battery} currently used by the motor bike
	 */
	@ManyToOne
	@JoinColumn(name = "battery_id")
	private Battery currentBattery;
	
	/**
	 * The make of the motor cycle
	 */
	@Column(name = "make", nullable = false)
    private String make;
	
	/**
	 * The model of the motor cycle
	 */
	@Column(name = "model", nullable = false)
    private String model;
	
	/**
	 * The colour of the motor cycle
	 */
	@Column(name = "colour", nullable = false)
    private String colour;
	
	/**
	 * The chassis number of the motor cycle
	 */
	@Column(name = "chassis_number", nullable = false)
    private String chassisNumber;
	
}
