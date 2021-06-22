package com.everis.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.everis.entity.Product;

@Repository
public class ProductRepositoryNativeImpl implements ProductRepositoryNavite {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Product> findAll() {
		Query nativeQuery = em.createNativeQuery(
				"SELECT id, name, description, stock, price, status FROM tbl_products ORDER BY id DESC");

		List<Object[]> results = nativeQuery.getResultList();

		return results
				.stream().map(result -> new Product(((BigInteger) result[0]).longValue(), (String) result[1],
						(String) result[2], (Double) result[3], (Double) result[4], (String) result[5]))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = em.createNamedQuery("getAllProducts", Product.class)
				.getResultList();
		return products;
	}

	@Override
	public List<Product> getAllProductsByCategoriesId(Long id) {
		List<Product> products = em.createNamedQuery("getAllProductsByCategoriesId", Product.class)
				.setParameter(1, id).getResultList();
		return products;
	}
	
    @Override
    public boolean addProduct(Product product) {
        try{
            em.persist(product);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

	@Override
	public List<Product> findByStatus(String status) {
		/*
		 * CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 * CriteriaQuery<Product> query = cb.createQuery(Product.class); Root<Product>
		 * product = query.from(Product.class);
		 * 
		 * Path<String> emailPath = product.get("status");
		 * 
		 * List<Predicate> predicates = new ArrayList<>(); for (String email : emails) {
		 * predicates.add(cb.like(emailPath, email)); } query.select(product)
		 * .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
		 * 
		 * return entityManager.createQuery(query) .getResultList();
		 */

		return null;
	}

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserSetStatusForNameNative(String status, Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertUser(String name, String description, Double stock, Double price, String status) {
		// TODO Auto-generated method stub

	}

}
