package com.pgichure.ampersand.setups.dtos;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 * 
 * <p> The CostSetup data transfer object class
 *
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Cost Setup", description = "Cost Setup details")
public class CostSetupDto {

	@ApiModelProperty(name = "id", notes = "The setup unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "date_from", notes = "The setup effective from date", required = true)
    private Date date_from;
	
	@ApiModelProperty(name = "date_to", notes = "The setup effective to date")
    private Date date_to;
	
	@ApiModelProperty(name = "cost_per_unit", notes = "The cost of an unit of charge in dollars")
    private BigDecimal cost_per_unit;
	
	@ApiModelProperty(name = "charges", notes = "The charges on an unit of charge in dollars")
    private BigDecimal charges;
	
}
