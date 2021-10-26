package com.pgichure.ampersand.operations.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 * <p> The Swap entity data transfer object class
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Swap", description = "Swap details")
public class SwapDto {

	@ApiModelProperty(name = "id", notes = "The unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "date_issued", notes = "The date of issue", required = true)
	private LocalDate date_issued;
	
	@ApiModelProperty(name = "date_returned", notes = "The date of return", required = true)
	private LocalDate date_returned;
	
	@ApiModelProperty(name = "driver_id", notes = "The ID of the driver issued to", required = true)
	private Long driver_id;
	
	@ApiModelProperty(name = "battery_id", notes = "The ID of the battery issued", required = true)
	private Long battery_id;
	
	@ApiModelProperty(name = "station_id", notes = "The ID of the station swapping was done", required = true)
	private Long station_id;
	
	@ApiModelProperty(name = "charge_issue_level", notes = "The battery charge level at issue", required = true)
	private BigDecimal charge_issue_level;
	
	@ApiModelProperty(name = "charge_return_level", notes = "The battery charge level at return")
	private BigDecimal charge_return_level;
	
	@ApiModelProperty(name = "issuance_mileage", notes = "The motor cycle mileage count at issuance", required = true)
	private BigDecimal issuance_mileage;
	
	@ApiModelProperty(name = "return_mileage", notes = "The motor cycle mileage count at return")
	private BigDecimal return_mileage;
	
}
