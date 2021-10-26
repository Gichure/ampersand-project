package com.pgichure.ampersand.setups.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.ampersand.setups.dtos.CostSetupDto;
import com.pgichure.ampersand.utils.Auditable;

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
public class CostSetup extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "setup_id", nullable = false)
    private Long id;
	
	@Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;
	
	@Column(name = "date_to", nullable = false)
    private LocalDate dateTo;
	
	@Column(name = "cost_per_unit", nullable = false)
    private BigDecimal costPerUnit;
	
	/**
	 * This method casts the {@link CostSetup} entity class to its {@link CostSetupDto}
	 * @return {@link CostSetupDto}
	 */
	public CostSetupDto getDto() {
		return CostSetupDto.builder()
				.date_from(this.getDateFrom())
				.date_to(this.getDateTo())
				.id(this.getId())
				.cost_per_unit(this.getCostPerUnit())
				.build();
	}

}
