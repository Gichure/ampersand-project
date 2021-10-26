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

import com.pgichure.ampersand.utils.Auditable;

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
public class Driver extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id", nullable = false)
    private Long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "license_number", nullable = false)
    private String licenseNumber;
	
	@Column(name = "identification_number", nullable = false)
    private String idNumber;
	
	@Column(name = "town")
    private String town;
	
	@Column(name = "locality")
    private String locality;
	
}
