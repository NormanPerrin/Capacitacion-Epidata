package cuentaTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class CuentaMethodTest {
	
	private CuentaSueldo cuenta1 = new CuentaSueldo("Euro", "Evil Corp");
	private CuentaCorriente cuenta0 = new CuentaCorriente("Dolar", "Epidata", 1000);
	private Set<Cuenta> cuentas = new HashSet<Cuenta>(Arrays.asList(cuenta0, cuenta1));
	private Cliente cliente0 = new Cliente("Norman", 7, "Laprida 193", cuentas);
	
	@Test
	public void testDepositarCero() {
		cuenta0.depositar(0);
		assertEquals(0, cuenta0.getSaldo(),0);
	}
	
	@Test
	public void testDepositarN() {
		cuenta0.depositar(10);
		assertEquals(10, cuenta0.getSaldo(),0);
	}
	
	@Test
	public void testDepositarNN() {
		cuenta0.depositar(10);
		cuenta0.depositar(10);
		assertEquals(20, cuenta0.getSaldo(),0);
	}
	
	@Test
	public void testRetirarCero() {
		try {
			cuenta0.extraer(0);
		} catch (Exception e) {
			fail();
		}
		assertEquals(0, cuenta0.getSaldo(),0);
	}
	
	@Test
	public void testRetirarN() {
		try {
			cuenta0.depositar(10);
			cuenta0.extraer(5);
		} catch (Exception e) {
			fail();
		}
		assertEquals(5, cuenta0.getSaldo(),0);
	}
	
	@Test
	public void testRetirarNN() {
		try {
			cuenta0.depositar(10);
			cuenta0.extraer(2);
			cuenta0.extraer(3);
		} catch (Exception e) {
			fail();
		}
		assertEquals(5, cuenta0.getSaldo(),0);
	}
	
	@Test
	public void testAsignarUnCliente() {
		assertTrue(cuenta0.pertenece(cliente0));
	}
	
	@Test
	public void testAsignarVariosCliente() {
		assertTrue(cuenta0.pertenece(cliente0) && cuenta1.pertenece(cliente0));
	}
	
}
