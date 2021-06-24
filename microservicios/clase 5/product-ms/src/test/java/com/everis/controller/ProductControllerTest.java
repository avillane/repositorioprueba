package com.everis.controller;

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
import org.springframework.http.ResponseEntity;

import com.everis.entity.Category;
import com.everis.entity.Product;
import com.everis.service.ProductService;
import com.everis.util.FileToObjectLoader;

public class ProductControllerTest {

	@InjectMocks
	private ProductController controller;

	@Mock
	private ProductService service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void whenListProductReturnSuccessful() throws IOException {

		Mockito.when(service.listAllProduct()).thenReturn(getListaProduct());
		Mockito.when(service.findByCategory(Mockito.any())).thenReturn(getListaProduct());

		ResponseEntity<List<Product>> testObserver = controller.listProduct(1L);

		assertEquals(testObserver.getBody().size(), 1);

	}
	
	@Test
	public void whenfindProductReturnSuccessful() {

		Mockito.when(service.findProduct(Mockito.anyLong())).thenReturn(getProduct());

		ResponseEntity<Product> testObserver = controller.findProduct(1L);

		assertEquals(testObserver.getBody().getId(), 1);

	}

	@Test
	public void whencreateProductReturnSuccessful() {

		Mockito.when(service.createProduct(Mockito.any())).thenReturn(getProduct());

		ResponseEntity<Product> testObserver = controller.createProduct(getProduct());

		assertEquals(testObserver.getBody().getId(), 1);

	}
	
	/*@Test
	public void whenupdateProductReturnSuccessful() {

		Mockito.when(service.updateProduct(Mockito.any())).thenReturn(getProduct());

		ResponseEntity<Product> testObserver = controller.updateProduct(1L, getProduct());

		assertEquals(testObserver.getBody().getId(), 1);

	}*/
	
	@Test
	public void whendeleteProductReturnSuccessful() {

		Mockito.when(service.deleteProduct(Mockito.anyLong())).thenReturn(getProduct());

		ResponseEntity<Product> testObserver = controller.deleteProduct(1L);

		assertEquals(testObserver.getBody().getId(), 1);

	}
	
	@Test
	public void whenupdateStockProductReturnSuccessful() {

		Mockito.when(service.updateStock(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(getProduct());

		ResponseEntity<Product> testObserver = controller.updateStockProduct(1L , 2.5);

		assertEquals(testObserver.getBody().getId(), 1);

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
