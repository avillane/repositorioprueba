package com.everis.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.entity.Category;
import com.everis.entity.Product;
import com.everis.repository.ProductRepository;
import com.everis.util.FileToObjectLoader;

public class ProductServiceImplTest {
	
	
	private ProductService service;

	@Mock
	private ProductRepository productRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		//productRepository = Mockito.mock(ProductRepository.class);
		
		service = new ProductServiceImpl(productRepository);
		
	}

	@Test
	public void whenListProductReturnSuccessful() throws IOException {

		Mockito.when(productRepository.findAll()).thenReturn(getListaProduct());

		List<Product> testObserver = service.listAllProduct();

		assertEquals(testObserver.size(), 1);

	}
	
	@Test
	public void whencreateProductReturnSuccessful() {

		Mockito.when(productRepository.save(Mockito.any())).thenReturn(getProduct());

		Product testObserver = service.createProduct(getProduct());

		assertEquals(testObserver.getId(), 8);

	}
	
	

	private Product getProduct( ) {
		return  Product.builder()
				.id(8L).name("zapatos")
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
