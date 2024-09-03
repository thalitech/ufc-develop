package com.ufc.sistemaufc;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ufc.sistemaufc.model.CategoriaFeminina;
import com.ufc.sistemaufc.model.CategoriaMasculina;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SistemaUfcApplicationTests {

	@Test
	public void categoriaMasculinaTest() {
		assertEquals(CategoriaMasculina.categoria(BigDecimal.valueOf(80)), CategoriaMasculina.MEDIO);
	}

	@Test(expected = RuntimeException.class)
	public void categoriaMasculinaErroZero() {
		CategoriaMasculina.categoria(BigDecimal.valueOf(0));
	}
	
	@Test(expected = RuntimeException.class)
	public void categoriaMasculinaErroGordo() {
		CategoriaMasculina.categoria(BigDecimal.valueOf(200));
	}
	
	@Test(expected = RuntimeException.class)
	public void categoriaFemininaErroGorda() {
		CategoriaFeminina.categoria(BigDecimal.valueOf(200));
	}
	
	@Test
	public void categoriaFeminiaTest() {
		assertEquals(CategoriaFeminina.categoria(BigDecimal.valueOf(1)), CategoriaFeminina.PALHA);
	}
}
