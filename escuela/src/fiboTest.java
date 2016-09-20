import static org.junit.Assert.*;

import org.junit.Test;


public class fiboTest {

	@Test
	public void testCero() {
		Fibo fibo = new Fibo();
		int[] resp = fibo.calcular(0);
		assertArrayEquals(new int[]{0}, resp);
	}
	
	@Test
	public void testUno() {
		Fibo fibo = new Fibo();
		int[] resp = fibo.calcular(1);
		assertArrayEquals(new int[]{0, 1}, resp);
	}
	
	@Test
	public void testNegativo() {
		Fibo fibo = new Fibo();
		int[] resp = fibo.calcular(-1);
		assertEquals(null, resp);
	}
	
	@Test
	public void testCantidadElementosArreglo() {
		Fibo fibo = new Fibo();
		int[] resp = fibo.calcular(10);
		assertTrue(resp.length == 11);
	}
	
	@Test
	public void testCasoNormal() {
		Fibo fibo = new Fibo();
		int[] resp = fibo.calcular(6);
		assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, resp);
	}
	
	@Test
	public void testLongInput() {
		Fibo fibo = new Fibo();
		int[] resp = fibo.calcular(Integer.MAX_VALUE);
		assertEquals(null, resp);
	}

}
