package com.everis.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.everis.entity.Category;
import com.everis.entity.Product;

@Repository
@RepositoryRestResource(path="productos", collectionResourceRel = "productoJson")
public interface ProductRepository  extends JpaRepository<Product, Long> {
    //public List<Product> findByCategory(Category category);
    
	public List<Product> findByStatus(@Param("status") String status);
	public List<Product> findByName(@Param("name") String name);
	
	@Query(value = "select * from tbl_products p where p.id = :id", nativeQuery = true)
	public Product findProductId(@Param("id") Long id);
	
	@Modifying
	@Query(value = "update tbl_products u set u.status = ? where u.id = ?", 
	  nativeQuery = true)
	int updateUserSetStatusForNameNative(String status, Long id);
	
	@Modifying
	@Query(
	  value = 
	    "insert into tbl_products (name, description, stock, price, status) values (:name, :description, :stock, :price, :status)",
	  nativeQuery = true)
	void insertUser(@Param("name") String name, @Param("description") String description, 
	  @Param("stock") Double stock, @Param("price") Double price, @Param("status") String status);
	
}
