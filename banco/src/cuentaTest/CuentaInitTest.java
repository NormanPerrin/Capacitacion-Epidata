package cuentaTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class CuentaInitTest {
	
	private static Cuenta cuenta2;
	private static Cuenta cuenta1;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuenta1 = new CuentaCorriente("Peso Argentino", "Evil Corp", 1000);
		cuenta2 = new CuentaSueldo("Peso Argentino", "Evil Corp");
	}
	
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
		assertEquals(0, cuenta1.getSaldo(),0);
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
