/**
 *  @author Paul
 * 
*   Oct 25, 2021
 * 
 */
package com.pgichure.ampersand.setups.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is the entity class for a motor cycle driver
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name ="tbl_registered_drivers")
@Entity
@Builder
@AllArgsConstructor
public class Driver implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The {@link Driver} unique identifier
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id", nullable = false)
    private Long id;
	
	/**
	 * Driver's name
	 */
	@Column(name = "name", nullable = false)
    private String name;
	
	/**
	 * The license number
	 */
	@Column(name = "license_number", nullable = false)
    private String licenseNumber;
	
	/**
	 * The identification number
	 */
	@Column(name = "identification_number", nullable = false)
    private String idNumber;
	
	/**
	 * The town of residence
	 */
	@Column(name = "town")
    private String town;
	
	/**
	 * The local area of residence
	 */
	@Column(name = "locality")
    private String locality;
	
}
