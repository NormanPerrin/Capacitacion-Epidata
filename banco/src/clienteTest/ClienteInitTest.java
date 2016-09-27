package clienteTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class ClienteInitTest {
	
	private static CuentaCorriente cuenta0;
	private static CuentaSueldo cuenta1;
	private static Set<Cuenta> cuentas;
	private static Cliente cliente0;
	private static Cliente cliente1;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuenta0 = new CuentaCorriente("Euro", "Epidata", 0);
		cuenta1 = new CuentaSueldo("Yen", "Lego");
		cuentas = new HashSet<Cuenta>(Arrays.asList(cuenta1, cuenta0));
		cliente0 = new Cliente("Norman", 3, "Muro 231", cuentas);
		cliente1 = new Cliente("Juan", 4, "Paredon 87", cuenta1);
	}
	
	@Test
	public void testNombre() {
		assertEquals("Juan", cliente1.getNombre());
	}
	
	@Test
	public void testDni() {
		assertEquals(4, cliente1.getDni());
	}
	
	@Test
	public void testDir() {
		assertEquals("Paredon 87", cliente1.getDir());
	}
	
	@Test
	public void testUnaCuenta() {
		assertTrue(cliente1.tieneCuenta(cuenta1));
	}
	
	@Test
	public void testVariasCuenta() {
		assertTrue(cliente0.tieneCuenta(cuentas));
	}
	
	@Test
	public void testContUnaCuenta() {
		assertEquals(1, cliente1.getContCuentas());
	}
	
	@Test
	public void testContDosCuentas() {
		assertEquals(2, cliente0.getContCuentas());
	}
	
	@Test
	public void testContCuentaCorriente() {
		assertEquals(1, cliente0.getContCuentasCorrientes());
	}
	
}
