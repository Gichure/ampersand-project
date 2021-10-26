package com.pgichure.ampersand.setups.dtos;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Paul
 * <p> The Station data transfer object class
 */
@Data
@AllArgsConstructor
@Builder
@ApiModel(value = "Station", description = "Station details")
public class StationDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty(name = "id", notes = "The unique identifier")
	private Long id;
	
	@ApiModelProperty(name = "name", notes = "The name of the station", required = true)
    private String name;
	
	@ApiModelProperty(name = "coordinates", notes = "The geographical coordinates of the station", required = true)
    private String coordinates;
	
	@ApiModelProperty(name = "town", notes = "The town where the station is located", required = true)
    private String town;
	
	@ApiModelProperty(name = "street", notes = "The street where the station is located", required = true)
    private String street;
	
	@ApiModelProperty(name = "building", notes = "The building where the station is housed")
    private String building;
	
}
