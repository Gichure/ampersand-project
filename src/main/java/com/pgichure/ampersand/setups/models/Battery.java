package com.pgichure.ampersand.setups.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.ampersand.setups.dtos.BatteryDto;
import com.pgichure.ampersand.utils.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is an entity class for a motor cycle battery {@link Battery}
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name ="tbl_batteries_inventory")
@Entity
@Builder
@AllArgsConstructor
public class Battery extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The battery unique identifier
	 */

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "battery_id")
    private Long id;
	
	/**
	 * The battery serial number
	 */
	@Column(name = "serial_number", nullable = false)
    private String serialNumber;
	
	
	/**
	 * The type of the battery
	 */
	@Column(name = "battery_type", nullable = false)
    private String batteryType;
	
	/**
	 * The battery voltage capacity
	 */
	@Column(name = "capacity", nullable = false)
    private String capacity;
	
	/**
	 * This method casts the {@link Battery} entity class to its {@link BatteryDto}
	 * @return {@link BatteryDto}
	 */
	public BatteryDto getDto() {
		return BatteryDto.builder()
				.battery_type(this.getBatteryType())
				.capacity(this.getCapacity())
				.id(this.getId())
				.serial_number(this.getSerialNumber())
				.build();
	}
}
