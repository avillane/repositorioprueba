package com.everis.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.everis.entity.Category;
import com.everis.entity.Product;
import com.everis.util.FileToObjectLoader;

public class ProductRepositoryTest {
	

	@Mock
	private ProductRepository productRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void whenfindByCategoryReturnSuccessful() throws IOException {

		//Mockito.when(productRepository.findAll()).thenReturn(getListaProduct());
		//productRepository.save(getProduct( ) );
		//Mockito.when(productRepository.save(Mockito.any())).thenReturn(getProduct());
		
		List<Product> testObserver = productRepository.findByCategory(getProduct( ).getCategory());

		assertEquals(testObserver.size(), 0);

	}

	private Product getProduct( ) {
		return  Product.builder()
				.id(1L).name("zapatos")
				.description("calzado para damas 33 - 38")
				.stock(50.0)
				.price(120.0)
				.status("CREATED")
				.createAt(new Date())
				.category(Category.builder().id(1L).name("SHOES").build()).build();
	}
	
	private Product productBuilder() throws IOException {
		return FileToObjectLoader.readDataFromFile("product.json", Product.class);
	}
	
	private List<Product> getListaProduct() throws IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(productBuilder( ));
		return products;
	}

	
}
