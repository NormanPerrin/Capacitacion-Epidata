package cuentaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class CuentaMethodTest {
	
	private CuentaSueldo cuenta1 = new CuentaSueldo("Euro", "Evil Corp");
	private CuentaCorriente cuenta0 = new CuentaCorriente("Dolar", "Epidata", 1000);
	private Cuenta[] cuentas = new Cuenta[]{cuenta0, cuenta1};
	private Cliente cliente0 = new Cliente("Norman", 7, "Laprida 193", cuentas);
	
	@Test
	public void testDepositarCero() {
		cuenta0.depositar(0);
		assertEquals(0, cuenta0.getSaldo());
	}
	
	@Test
	public void testDepositarN() {
		cuenta0.depositar(10);
		assertEquals(10, cuenta0.getSaldo());
	}
	
	@Test
	public void testDepositarNN() {
		cuenta0.depositar(10);
		cuenta0.depositar(10);
		assertEquals(20, cuenta0.getSaldo());
	}
	
	@Test
	public void testRetirarCero() {
		cuenta0.retirar(0);
		assertEquals(0, cuenta0.getSaldo());
	}
	
	@Test
	public void testRetirarN() {
		cuenta0.depositar(10);
		cuenta0.retirar(5);
		assertEquals(5, cuenta0.getSaldo());
	}
	
	@Test
	public void testRetirarNN() {
		cuenta0.depositar(10);
		cuenta0.retirar(2);
		cuenta0.retirar(3);
		assertEquals(5, cuenta0.getSaldo());
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
