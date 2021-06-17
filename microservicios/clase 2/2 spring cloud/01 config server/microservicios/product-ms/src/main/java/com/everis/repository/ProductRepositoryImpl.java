package com.everis.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.everis.entity.Category;
import com.everis.entity.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	private List<Category> categories = new ArrayList<Category>();
	private List<Product> products = new ArrayList<Product>();
	
	private void init() {
		Category c1 = new Category(1L, "shoes");
		Category c2 = new Category(2L, "books");
		Category c3 = new Category(3L, "electronics");
		
		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
				
		Product p1 = new Product(1L, "adidas Cloudfoam Ultimate","Walk in the air in the back", 2.0, 20.0, "CREATED", new Date(),c1);
		Product p2 = new Product(2L,"under armour men","Micro G assert", 4.0, 40.0, "CREATED", new Date(),c1);
		Product p3 = new Product(3L, "Spring Boot in Action","Caig walls is a software developer", 6.0, 60.0, "CREATED",  new Date(), c2);

		products.add(p1);
		products.add(p2);
		products.add(p3);
	}
	
	public ProductRepositoryImpl( ) {
		init();
	}
	
	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public Optional<Product> findById(Long id) {
		return products.stream().filter(p ->   p.getId() == id).findAny();
	}
	
	@Override
	public <S extends Product> S save(S entity) {
		products.add(entity);		
		return entity;
	}
	
	@Override
	public List<Product> findByCategory(Category category) {
		return products.stream().filter(p ->   p.getCategory().getId() == category.getId()).collect(Collectors.toList());
	}	
	
}
