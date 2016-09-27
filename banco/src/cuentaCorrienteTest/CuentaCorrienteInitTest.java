package cuentaCorrienteTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.Cuenta;
import banco.CuentaCorriente;

public class CuentaCorrienteInitTest {
	
	private static Cuenta cuenta2;
	private static Cuenta cuenta1;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuenta1 = new CuentaCorriente("Peso Argentino", "Ikea", 1000);
		cuenta2 = new CuentaCorriente("Peso Mexicano", "Coto", 250);
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
	public void testSaldoInicial() {
		assertEquals(1000, cuenta1.getSaldo(),0);
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
