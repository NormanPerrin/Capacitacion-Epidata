package cuentaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class CuentaInitTest {
	
	private Cuenta cuenta2 = new CuentaSueldo("Peso Argentino", "Evil Corp"); // numero = 2; saldo = 0;
	private Cuenta cuenta1 = new CuentaCorriente("Peso Argentino", "Evil Corp", 1000); // numero = 1; saldo = 0;
	
	@Test
	public void testNumeroCero() {
		assertEquals(1, cuenta1.getNumero());
	}
	
	@Test
	public void testNumeroN() {
		assertEquals(2, cuenta2.getNumero());
	}
	
	@Test
	public void testSaldoCero() {
		assertEquals(0, cuenta1.getSaldo());
	}
	
	@Test
	public void testMoneda() {
		assertEquals("Peso Argentino", cuenta1.getMoneda());
	}
	
	@Test
	public void testNumeroCuentas() {
		assertEquals(2, cuenta1.getNumeroCuentas());
	}
	
}
