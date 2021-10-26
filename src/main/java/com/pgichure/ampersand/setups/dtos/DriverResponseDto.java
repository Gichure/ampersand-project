package com.pgichure.ampersand.setups.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.pgichure.ampersand.operations.dtos.SwapDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 * <p> The Driver entity data transfer object
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Driver", description = "Driver details")
public class DriverResponseDto {

	@ApiModelProperty(name = "id", notes = "The driver unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "name", notes = "The name of the driver")
    private String name;
	
	@ApiModelProperty(name = "license_number", notes = "The license number of the driver")
    private String license_number;
	
	@ApiModelProperty(name = "identification_number", notes = "The identification number of the driver")
    private String identification_number;
	
	@ApiModelProperty(name = "town", notes = "The town residence of the driver")
    private String town;
	
	@ApiModelProperty(name = "locality", notes = "The locality of the driver")
    private String locality;
	
	@ApiModelProperty(name = "swaps", notes = "The list of driver's swaps")
	private List<SwapDto> swaps;
	
	@ApiModelProperty(name = "total_consumption", notes = "The driver's total consumption")
	private BigDecimal total_consumption;
	
}
