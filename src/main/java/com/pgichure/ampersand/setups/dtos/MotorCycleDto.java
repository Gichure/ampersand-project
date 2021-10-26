package com.pgichure.ampersand.setups.dtos;

import com.pgichure.ampersand.setups.models.MotorCycle;

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
public class MotorCycleDto {

	@ApiModelProperty(name = "id", notes = "The unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "driverId", notes = "The driver's ID")
	private Long driverId;
	
	@ApiModelProperty(name = "make", notes = "The motor cycle's make")
    private String make;
	
	@ApiModelProperty(name = "model", notes = "The motor cycle's model")
    private String model;
	
	@ApiModelProperty(name = "colour", notes = "The motor cycle's colour")
    private String colour;
	
	@ApiModelProperty(name = "chassisNumber", notes = "The motor cycle's chassis number")
    private String chassisNumber;
	
	/**
	 * This method casts the {@link MotorCycleDto} class to its {@link MotorCycle} entity class
	 * @return {@link MotorCycle}
	 */
	
	public MotorCycle getEntity() {
		return MotorCycle.builder()
				.id(this.getId())
				.chassisNumber(this.getChassisNumber())
				.colour(this.getColour())
				.make(this.getMake())
				.model(this.getModel())
				.build();
	}
	
}
