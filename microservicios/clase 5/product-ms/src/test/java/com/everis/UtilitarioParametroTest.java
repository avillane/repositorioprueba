package com.everis;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.everis.utils.Utilitario;

// para demostrarlo,
@RunWith(value = Parameterized.class)
public class UtilitarioParametroTest {

	@Parameters
	public static Iterable<Object[]> getData() {
		/*List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {3, 1, 4});
		obj.add(new Object[] {2, 3, 5});
		obj.add(new Object[] {3, 3, 6});
		return obj;*/
		return Arrays.asList(new Object[][] {
			{3, 1, 4}, {2, 3, 5}, {3, 3, 6}
		});
	}
	int a, b, exp;
	
	public UtilitarioParametroTest(int a, int b, int exp ) {
		this.a = a ;
		this.b = b;
		this.exp = exp;
	}

	@Test
	public void whensumathenOK() {
		int resultado = Utilitario.suma(a, b);
		assertEquals(exp, resultado);
	}
  
	/*@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		assertEquals(expectedResult, Utilitario.suma(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}*/
   
}

