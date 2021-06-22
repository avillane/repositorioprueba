package com.everis;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.everis.entity.Category;
import com.everis.entity.Product;
import com.everis.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

	@Autowired
	private ProductRepository productRepository;
	
	/*@Test
	public void whenFindByCategoryThenReturnListProduct() {
		Product product01 = Product.builder()
				.name("computer")
				.category(Category.builder().id(1L).build())
				.description("")
				.stock(Double.parseDouble("10"))
				.price(Double.parseDouble("1240.99"))
				.status("ACTIVO")
				.createAt(new Date()).build();
		
		productRepository.save(product01);
		
		List<Product> founds = productRepository.findByCategory(product01.getCategory());
        Assertions.assertThat(founds.size()).isEqualTo(3);	
		
	}*/
}
