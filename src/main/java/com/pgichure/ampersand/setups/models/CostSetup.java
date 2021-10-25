package com.pgichure.ampersand.setups.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.ampersand.utils.Auditable;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 * <p>This is an entity class for a cost of charge
 */
@Data
@RequiredArgsConstructor
@Table(name ="tbl_cost_setups")
@Entity
public class CostSetup extends Auditable<String> implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "setup_id")
    private Long id;

}
