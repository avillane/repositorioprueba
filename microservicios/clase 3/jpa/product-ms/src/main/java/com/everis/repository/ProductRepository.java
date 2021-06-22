package com.everis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everis.entity.Category;
import com.everis.entity.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
	
	public List<Product> findByCategory(Category category);
    
	public List<Product> findByStatus(@Param("status") String status);
	public List<Product> findByName(@Param("name") String name);
	
	@Query(value = "select * from tbl_products p where p.id = :id", nativeQuery = true)
	public Product findProductId(@Param("id") Long id);
	
  
}
