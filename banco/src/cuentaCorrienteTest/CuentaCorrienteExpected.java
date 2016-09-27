package cuentaCorrienteTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;

public class CuentaCorrienteExpected {
	
	private Cuenta cuenta;
	
	@Before
	public void setUp() {
		cuenta = new CuentaCorriente("Dolar", "Epidata", 250);
	}
	
	// depositar
	@Test
	public void testDepositarCero() {
		cuenta.depositar(0);
		assertEquals(250, cuenta.getSaldo(),0);
	}
	
	@Test
	public void testDepositarUnaVez() {
		cuenta.depositar(250);
		assertEquals(500, cuenta.getSaldo(),0);
	}
	
	
	@Test
	public void testDepositarConComaUnaVez() {
		cuenta.depositar(250.50);
		assertEquals(500.50, cuenta.getSaldo(),0);
	}
	
	@Test
	public void testDepositarConComaDosVeces() {
		cuenta.depositar(250.50);
		cuenta.depositar(0.50);
		assertEquals(501, cuenta.getSaldo(),0);
	}
	
	// extraer
	@Test
	public void testExtraerSinSaldoCero() {
		try {
			cuenta.extraer(0);
			assertEquals(250, cuenta.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerSinSaldoUnaVez() {
		try {
			cuenta.extraer(100);
			assertEquals(150, cuenta.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerSinSaldoDosVeces() {
		try {
			cuenta.extraer(100);
			cuenta.extraer(150);
			assertEquals(0, cuenta.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerConSaldoCero() {
		try {
			cuenta.depositar(250);
			cuenta.extraer(0);
			assertEquals(500, cuenta.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerConSaldoUnaVez() {
		try {
			cuenta.depositar(250);
			cuenta.extraer(100);
			assertEquals(400, cuenta.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerConSaldoDosVeces() {
		try {
			cuenta.depositar(250);
			cuenta.extraer(100);
			cuenta.extraer(300);
			assertEquals(100, cuenta.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	// asignar: falla en la asignación de cuenta1 <TODO>
	@Test
	public void testAsignarNingunCliente() {
		Cliente cliente = new Cliente("Norman", 3, "Freire 432", cuenta);
		assertTrue(cuenta.pertenece(cliente));
	}
	
	@Test
	public void testAsignarUnCliente() {
		Cliente cliente = new Cliente("Norman", 3, "Freire 432", cuenta);
		Cuenta cuenta2 = new CuentaCorriente("Euro", "Carlitos", 400);
		cuenta2.asignar(cliente);
		assertTrue(cuenta.pertenece(cliente) && cuenta2.pertenece(cliente));
	}
	
	@Test
	public void testAsignarVariosClientes() {
		Cliente cliente = new Cliente("Norman", 3, "Freire 432", cuenta);
		Cuenta cuenta2 = new CuentaCorriente("Euro", "Carlitos", 400);
		Cuenta cuenta3 = new CuentaCorriente("Euro", "Carlitos", 400);
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta2);
		cuentas.add(cuenta3);
		cliente.agregarCuenta(cuentas);
		assertTrue(cuenta.pertenece(cliente) && cuenta2.pertenece(cliente) && cuenta3.pertenece(cliente));
	}
	
}
