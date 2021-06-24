package com.everis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.entity.Category;
import com.everis.entity.Product;
import com.everis.entity.dto.ProductDto;
import com.everis.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> listProduct(@RequestParam(name="categoryId", required = false) Long categoryId) {
		List<Product> products = null;
		if(categoryId == null) {
			 products = productService.listAllProduct();
			 if(products.isEmpty()) {
					return ResponseEntity.notFound().build();
			 }
		}else {
			 products = productService.findByCategory(Category.builder().id(categoryId).build());
			 if(products.isEmpty()) {
					return ResponseEntity.notFound().build();
			}
		}

		return ResponseEntity.ok(products);
	}
	
	/*@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		Product product = productService.getProduct(id);
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable("id") Long id) {
		Product product = productService.findProduct(id);
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product productCreate = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id")Long id, @RequestBody ProductDto product) {
		product.setId(id);
		Product productDB = productService.updateProduct(mapper(product));
		if(productDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productDB);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable ("id") Long id) {
		Product productDelete = productService.deleteProduct(id);
		if(productDelete == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productDelete);
	}
	
	@GetMapping(value = "/{id}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id, @RequestParam(name="quantity", required = true) Double quantity) {
		Product product = productService.updateStock(id, quantity);
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	public Product mapper(ProductDto productDto) {
		return Product.builder()
				.id(productDto.getId())
				.name(productDto.getName())
				.description(productDto.getDescription())
				.stock(productDto.getStock())
				.price(productDto.getPrice())
				.status(productDto.getStatus())
				.createAt(productDto.getCreateAt())
				.category(Category.builder()
						.id(productDto.getCategory().getId())
						.name(productDto.getCategory().getName())
						.build())
				.build();
	}
	
}
