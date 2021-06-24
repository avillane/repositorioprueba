package com.everis;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.everis.utils.Utilitario;

public class UtilitarioTest {

	//se ejecuta unica vez
	@BeforeClass
	public static void initUnico() {
		System.out.println("inicio unico");
	}
	@AfterClass
	public static void finishUnica() {
		System.out.println("finalizar unico");
	}
	// en cada ejecución se inicializa
	@Before
	public void init() {
		System.out.println("inicializar");
	}
	@After
	public void finish() {
		System.out.println("finalizar");
	}
	
	@Test
	public void test() {
		// fail("fallo");
	}

	@Test
	public void whensumathenOK() {
		int resultado = Utilitario.suma(1, 2);
		int esperado = 3;
		assertEquals(resultado, esperado);
	}

	@Test
	public void whensumathenError() {
		int resultado = Utilitario.suma(1, 2);
		int esperado = 2;		
		assertNotEquals(resultado, esperado);
	}

	@Test
	public void whensRestathenOK() {
		int resultado = Utilitario.resta(3, 2);
		int esperado = 1;
		assertEquals(resultado, esperado);
	}	
	
	//nombre es la expcion que generaste
	//expected, que indica que siempre va fallar
	// x eso debemos hacer que llegue a la excepcion.
	@Test(expected = ArithmeticException.class)
	public void whensDividirthenOK() {
		int resultado = Utilitario.dividir(3, 0);
	}	
   /*@Test(timeout = 100) //milisegundos
   public void testAlgoritmoOptimo() {
	   Utilitario util = new Utilitario();
	   util.operacionOptima();
   }*/
   
   
}

