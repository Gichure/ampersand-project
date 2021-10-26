package com.pgichure.ampersand.setups.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 * <p> The MotorCycle entity data transfer object
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Motor Cycle", description = "Motor Cycle details")
public class MotorCycleResponseDto {

	@ApiModelProperty(name = "id", notes = "The unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "driver", notes = "The driver")
	private DriverDto driver;
	
	@ApiModelProperty(name = "battery", notes = "The current battery")
	private BatteryDto battery;
	
	@ApiModelProperty(name = "make", notes = "The motor cycle's make")
    private String make;
	
	@ApiModelProperty(name = "model", notes = "The motor cycle's model")
    private String model;
	
	@ApiModelProperty(name = "colour", notes = "The motor cycle's colour")
    private String colour;
	
	@ApiModelProperty(name = "chassisNumber", notes = "The motor cycle's chassis number")
    private String chassisNumber;
	
}
