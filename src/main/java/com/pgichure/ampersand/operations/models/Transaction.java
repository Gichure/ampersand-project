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

import com.pgichure.ampersand.utils.Auditable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is an entity class for a transaction
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name ="tbl_transactions")
@Entity
public class Transaction extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id", nullable = false)
    private Long id;
	
	@Column(name = "transaction_date", nullable = false)
	private LocalDate transactionDate;
	
	@ManyToOne
	@JoinColumn(name = "log_id", nullable = false)
	private SwappingLog swap;
	
	@Column(name = "units_used", nullable = false)
	private BigDecimal units;
	
	@Column(name = "cost_per_unit", nullable = false)
	private BigDecimal costPerUnit;

	@Column(name = "gross_amount", nullable = false)
	private BigDecimal grossAmount;
	
	@Column(name = "charges", nullable = false)
	private BigDecimal charges;
	
	@Column(name = "net_amount", nullable = false)
	private BigDecimal netAmount;
	
}
