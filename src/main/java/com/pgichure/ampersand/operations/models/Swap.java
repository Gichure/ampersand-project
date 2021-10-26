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

import com.pgichure.ampersand.operations.dtos.SwapDto;
import com.pgichure.ampersand.setups.models.Battery;
import com.pgichure.ampersand.setups.models.Driver;
import com.pgichure.ampersand.setups.models.Station;
import com.pgichure.ampersand.utils.Auditable;

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
public class Swap extends Auditable<String> implements Serializable{/**
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
	private Battery batteryIssued;
	
	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	private Station station;
	
	@Column(name = "charge_issue_level", nullable = false)
	private BigDecimal chargeIssueLevel;
	
	@Column(name = "charge_return_level")
	private BigDecimal chargeReturnLevel;
	
	@Column(name = "issuance_mileage", nullable = false)
	private BigDecimal issuanceMileage;
	
	@Column(name = "return_mileage")
	private BigDecimal returnMileage;
	
	/**
	 * This method casts the {@link Swap} entity class to its {@link SwapDto}
	 * @return {@link SwapDto}
	 */
	
	public SwapDto getDto() {
		return SwapDto.builder()
				.charge_issue_level(this.getChargeIssueLevel())
				.charge_return_level(this.getChargeReturnLevel())
				.date_issued(this.getDateIssued())
				.date_returned(this.getDateReturned())
				.id(this.getId())
				.issuance_mileage(this.getIssuanceMileage())
				.return_mileage(this.getReturnMileage())
				.battery_id(this.getBatteryIssued() == null ? null : this.getBatteryIssued().getId())
				.driver_id(this.getIssuedTo() == null ? null : this.getIssuedTo().getId())
				.station_id(this.getStation() == null ? null : this.getStation().getId())
				.build();
	}
}
