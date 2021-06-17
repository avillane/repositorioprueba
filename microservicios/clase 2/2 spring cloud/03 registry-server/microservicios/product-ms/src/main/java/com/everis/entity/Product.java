package com.everis.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Product {
	
	private Long id;	
	private String name;	
	private String description;	
	private Double stock;
	private Double price;
	private String status;

	private Date createAt;
	private Category category;

}
