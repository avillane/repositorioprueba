package com.everis.entity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductDto implements Serializable {


	private Long id;

	private String name;
	private String description;
	private Double stock;
	private Double price;
	private String status;
	private Date createAt;
	
	private CategoryDto category;
	
	public ProductDto(Long id, String name, String description, Double stock, Double price, String status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock; 
		this.price = price;
		this.status =status;
	}
}