package com.everis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.entity.Category;
import com.everis.entity.Product;
import com.everis.repository.ProductRepository;
import com.everis.repository.ProductRepositoryNavite;

@Service
public class ProductServiceImpl implements ProductService {
	
    @Autowired
	private ProductRepository productRepository;
    
    @Autowired
	private ProductRepositoryNavite productRepositoryNative;
    
	@Override
	public List<Product> listAllProduct() {
		//return productRepository.findAll();
		//return productRepositoryNative.findAll();
		return productRepositoryNative.getAllProducts();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product findProduct(Long id) {
		return productRepository.findProductId(id);
	}

	
	@Override
	public Product createProduct(Product product) {
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		//return productRepository.save(product);
		return productRepositoryNative.addProduct(product) ? product : null;
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB = getProduct(product.getId());
		if(productDB == null) {
			return null;
		}
		productDB.setName(product.getName());	
		productDB.setDescription(product.getDescription());
		//productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
			
		return productRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDB = getProduct(id);
		if(productDB == null) {
			return null;
		}
		productDB.setStatus("DELETED");
		return productRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		//return null;//productRepository.findByCategory(category);
		return productRepositoryNative.getAllProductsByCategoriesId(category.getId());
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDB = getProduct(id);
		if(productDB == null) {
			return null;
		}
		Double stock = productDB.getStock() + quantity;
		productDB.setStock(stock);
		return productRepository.save(productDB);
	}


}
