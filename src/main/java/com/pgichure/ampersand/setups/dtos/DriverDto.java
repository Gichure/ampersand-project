package com.pgichure.ampersand.setups.dtos;

import com.pgichure.ampersand.setups.models.Driver;

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
public class DriverDto {

	@ApiModelProperty(name = "id", notes = "The driver unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "name", notes = "The name of the driver", required = true)
    private String name;
	
	@ApiModelProperty(name = "license_number", notes = "The license number of the driver", required = true)
    private String license_number;
	
	@ApiModelProperty(name = "identification_number", notes = "The identification number of the driver", required = true)
    private String identification_number;
	
	@ApiModelProperty(name = "town", notes = "The town residence of the driver", required = true)
    private String town;
	
	@ApiModelProperty(name = "locality", notes = "The locality of the driver", required = true)
    private String locality;
	
	/**
	 * This method casts the {@link DriverDto} class to its {@link Driver} entity class
	 * @return {@link Driver}
	 */
	public Driver getEntity() {
		
		return Driver.builder()
				.id(this.getId())
				.idNumber(this.getIdentification_number())
				.licenseNumber(this.getLicense_number())
				.locality(this.getLocality())
				.name(this.getName())
				.town(this.getTown())
				.build();
	}
	
}
