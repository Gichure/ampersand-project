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

import com.pgichure.ampersand.operations.dtos.TransactionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
public class Transaction implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The {@link Transaction} unique identifier
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id", nullable = false)
    private Long id;
	
	/**
	 * The transaction date
	 */
	@Column(name = "transaction_date", nullable = false)
	private Date transactionDate;
	
	/**
	 * The {@link Swap} associated with the transaction
	 */
	@ManyToOne
	@JoinColumn(name = "swap_id", nullable = false)
	private Swap swap;
	
	/**
	 * The transaction units of charge
	 */
	@Column(name = "units_used", nullable = false)
	private BigDecimal units;
	
	/**
	 * The cost per unit as at time of transaction
	 */
	@Column(name = "cost_per_unit", nullable = false)
	private BigDecimal costPerUnit;

	/**
	 * The transaction gross amount
	 */
	@Column(name = "gross_amount", nullable = false)
	private BigDecimal grossAmount;
	
	/**
	 * The transaction charges
	 */
	@Column(name = "charges", nullable = false)
	private BigDecimal charges;
	
	/**
	 * The transaction net amount
	 */
	@Column(name = "net_amount", nullable = false)
	private BigDecimal netAmount;
	
}
