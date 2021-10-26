package com.pgichure.ampersand.operations.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.pgichure.ampersand.operations.models.Transaction;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 *
 * <p> The Transaction data transfer object class
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Transaction", description = "Transaction details")
public class TransactionDto {

	@ApiModelProperty(name = "id", notes = "The unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "transaction_date", notes = "The transaction date", required = true)
	private Date transactionDate;
	
	@ApiModelProperty(name = "swap_id", notes = "The transaction's swap identifier", required = true)
	private Long swapId;
	
	@ApiModelProperty(name = "units_used", notes = "The units consumed", required = true)
	private BigDecimal units;
	
	@ApiModelProperty(name = "cost_per_unit", notes = "The cost per unit", required = true)
	private BigDecimal cost_per_unit;

	@ApiModelProperty(name = "gross_amount", notes = "The gross amount of the transaction", required = true)
	private BigDecimal gross_amount;
	
	@ApiModelProperty(name = "charges", notes = "The charges of the transaction", required = true)
	private BigDecimal charges;
	
	@ApiModelProperty(name = "net_amount", notes = "The net amount of the transaction", required = true)
	private BigDecimal net_amount;
	
}
