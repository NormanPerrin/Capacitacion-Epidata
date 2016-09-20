import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;


public class calculadoraTest {

	@Test
	public void testSumaCero() {
		Calculadora calc = new Calculadora(0);
		int suma = calc.suma(0, 0);
		assertEquals(0, suma);
	}	
	
	@Test
	public void testSumaPositiva() {
		Calculadora calc = new Calculadora(0);
		int suma = calc.suma(1, 2);
		assertTrue(suma > 0);
	}
	
	@Test
	public void testUltimoValor() {
		Calculadora calc = new Calculadora(1);
		calc.suma(1, 2);
		assertEquals(3, calc.getUltimoResultado());
	}
	
	@Test
	public void testInitialize() {
		Calculadora calc = new Calculadora(3);
		assertEquals(3, calc.getUltimoResultado());
	}

}
