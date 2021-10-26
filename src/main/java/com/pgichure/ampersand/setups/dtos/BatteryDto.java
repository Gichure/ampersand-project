package com.pgichure.ampersand.setups.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 * The Battery data transfer object class
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Battery", description = "Battery details")
public class BatteryDto {

	@ApiModelProperty(name = "id", notes = "The battery unique identifier")
    private Long id;
	
	@ApiModelProperty(name = "serial_number", notes = "The battery serial number", required = true)
    private String serial_number;
	
	@ApiModelProperty(name = "battery_type", notes = "The battery type", required = true)
    private String battery_type;
	
	@ApiModelProperty(name = "capacity", notes = "The battery voltage capacity", required = true)
    private String capacity;
}
