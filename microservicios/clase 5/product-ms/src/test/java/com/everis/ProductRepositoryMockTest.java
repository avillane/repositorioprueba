package com.everis;

import static org.junit.Assert.*;


import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
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
				.status("CREATED")
				.createAt(new Date()).build();
		
		//productRepository.save(product01);
		
		List<Product> founds = productRepository.findByCategory(product01.getCategory());
        Assertions.assertThat(founds.size()).isEqualTo(1);	
		
	}*/
	@Before
	@Test
	public void initial() {
		System.out.println("inicializar");
	}
	@Test
	public void whenExample() {
		System.out.println("inicio example");
		assertEquals(5, 5);
		assertTrue(true);
		assertFalse(false);
		
	}
	// para las excepciones
	/*@Test(expected = )
	public void whenExampleException() {
		
	}*/
}
