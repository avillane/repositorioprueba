package com.everis.repository;

import java.util.List;
import java.util.Optional;

import com.everis.entity.Category;
import com.everis.entity.Product;

public interface ProductRepository {
	public List<Product> findAll();
	public Optional<Product> findById(Long id) ;
	public <S extends Product> S save(S entity);
    public List<Product> findByCategory(Category category);
}
