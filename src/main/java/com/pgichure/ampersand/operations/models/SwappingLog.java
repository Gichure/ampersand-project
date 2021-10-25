package com.pgichure.ampersand.operations.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.utils.Auditable;

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
public class SwappingLog extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
    private Long id;
	
	@Column(name = "date_issued", nullable = false)
	private LocalDate dateIssued;
	
	@Column(name = "date_returned")
	private LocalDate dateReturned;
	
	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	private Driver issuedTo;
	
	@ManyToOne
	@JoinColumn(name = "battery_id", nullable = false)
	private Driver batteryIssued;
	
	@Column(name = "charge_issue_level", nullable = false)
	private BigDecimal chargeIssueLevel;
	
	@Column(name = "charge_return_level")
	private BigDecimal chargeReturnLevel;
	
	@Column(name = "issuance_mileage", nullable = false)
	private BigDecimal issuanceMileage;
	
	@Column(name = "return_mileage")
	private BigDecimal returnMileage;
}
