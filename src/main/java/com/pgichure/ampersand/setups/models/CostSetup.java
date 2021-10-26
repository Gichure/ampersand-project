package com.pgichure.ampersand.setups.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.ampersand.setups.dtos.CostSetupDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is an entity class for a cost of charge
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name ="tbl_cost_setups")
@Entity
@Builder
@AllArgsConstructor
public class CostSetup implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The {@link CostSetup} unique identifier
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "setup_id", nullable = false)
    private Long id;
	
	/**
	 * Setup effective from date
	 */
	@Column(name = "date_from", nullable = false)
    private Date dateFrom;
	
	/**
	 * Setup effective to date
	 */
	@Column(name = "date_to", nullable = false)
    private Date dateTo;
	
	/**
	 * Cost per unit in Dollars
	 */
	@Column(name = "cost_per_unit", nullable = false)
    private BigDecimal costPerUnit;
	
	/**
	 * Cost per unit in Dollars
	 */
	@Column(name = "", nullable = false)
    private BigDecimal applicableCharges;
	
}
