package com.everis.entity;

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

@Entity
@Table(name = "tbl_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@NamedNativeQueries({
       @NamedNativeQuery(
               name    =   "getAllProducts",
               query   =   "SELECT tbl_products.id, tbl_products.name, description, stock, price, status, create_at,  tbl_categories.id as category_id, tbl_categories.name " +
                           "FROM tbl_products,tbl_categories",
                           resultClass=Product.class
       ),
       @NamedNativeQuery(
               name    =   "getAllProductsByCategoriesId",
               query   =   "SELECT tbl_products.id, tbl_products.name, description, stock, price, status, create_at,  tbl_categories.id as category_id, tbl_categories.name " +
                           "FROM tbl_products, tbl_categories " + 
                           "WHERE tbl_categories.id = ?",
                           resultClass=Product.class
       )
})
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El nombre no debe ser vacío")
	private String name;
	private String description;
	@Positive(message = "El stock debe ser mayor que cero")
	private Double stock;
	private Double price;
	private String status;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@NotNull(message = "La categoria no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Category category;
	
	public Product(Long id, String name, String description, Double stock, Double price, String status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock; 
		this.price = price;
		this.status =status;
	}
}