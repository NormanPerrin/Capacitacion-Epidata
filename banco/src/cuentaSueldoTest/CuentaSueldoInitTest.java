package cuentaSueldoTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.Cuenta;
import banco.CuentaSueldo;

public class CuentaSueldoInitTest {

	private static Cuenta cuenta2;
	private static Cuenta cuenta1;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuenta1 = new CuentaSueldo("Peso Argentino", "Ikea");
		cuenta2 = new CuentaSueldo("Peso Mexicano", "Coto");
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
	public void testEmpresa() {
		assertEquals("Ikea", cuenta1.getEmpresa());
	}
	
	@Test
	public void testNumeroCuentas() {
		assertEquals(2, cuenta1.getNumeroCuentas());
	}

}
