package com.pgichure.ampersand.operations.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.models.MotorCycle;
import com.pgichure.ampersand.setups.models.Station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is an entity class for a motor cycle battery swapping entry
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name ="tbl_swapping_logs")
@Entity
@Builder
@AllArgsConstructor
public class Swap implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The {@link Swap} unique identifier
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
    private Long id;
	
	/**
	 * The swap date
	 */
	@Column(name = "date_issued", nullable = false)
	private Date dateIssued;
	
	/**
	 * The swap return date
	 */
	@Column(name = "date_returned")
	private Date dateReturned;
	
	/**
	 * The motor bike the battery was issued to
	 */
	@ManyToOne
	@JoinColumn(name = "bike_id", nullable = false)
	private MotorCycle issuedTo;
	
	/**
	 * The battery that was issued out
	 */
	@ManyToOne
	@JoinColumn(name = "battery_id", nullable = false)
	private Battery batteryIssued;
	
	/**
	 * The issuing station
	 */
	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	private Station station;
	
	/**
	 * The battery charge level at time of issue
	 */
	@Column(name = "charge_issue_level", nullable = false)
	private BigDecimal chargeIssueLevel;
	
	/**
	 * The battery charge level at time of return
	 */
	@Column(name = "charge_return_level")
	private BigDecimal chargeReturnLevel;
	
	/**
	 * The motor cycle mileage at time of issue
	 */
	@Column(name = "issuance_mileage", nullable = false)
	private BigDecimal issuanceMileage;
	
	/**
	 * The motor cycle mileage at time of return
	 */
	@Column(name = "return_mileage")
	private BigDecimal returnMileage;
	
}
