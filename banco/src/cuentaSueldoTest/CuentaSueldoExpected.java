package cuentaSueldoTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;
import excepciones.SaldoInsuficienteException;

public class CuentaSueldoExpected {

private Cuenta cuenta1;
	
	@Before
	public void setUp() {
		cuenta1 = new CuentaSueldo("Dolar", "Epidata");
	}
	
	// depositar
	@Test
	public void testDepositarCero() {
		cuenta1.depositar(0);
		assertEquals(0, cuenta1.getSaldo(),0);
	}
	
	@Test
	public void testDepositarUnaVez() {
		cuenta1.depositar(250);
		assertEquals(250, cuenta1.getSaldo(),0);
	}
	
	
	@Test
	public void testDepositarConComaUnaVez() {
		cuenta1.depositar(250.50);
		assertEquals(250.50, cuenta1.getSaldo(),0);
	}
	
	@Test
	public void testDepositarConComaDosVeces() {
		cuenta1.depositar(250.50);
		cuenta1.depositar(0.50);
		assertEquals(251, cuenta1.getSaldo(),0);
	}
	
	// extraer
	@Test
	public void testExtraerConSaldoCero() {
		try {
			cuenta1.depositar(250);
			cuenta1.extraer(0);
			assertEquals(250, cuenta1.getSaldo(),0);
		} catch (SaldoInsuficienteException e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerConSaldoUnaVez() {
		try {
			cuenta1.depositar(250);
			cuenta1.extraer(100);
			assertEquals(150, cuenta1.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testExtraerConSaldoDosVeces() {
		try {
			cuenta1.depositar(600);
			cuenta1.extraer(100);
			cuenta1.extraer(300);
			assertEquals(200, cuenta1.getSaldo(),0);
		} catch (Exception e) {
			fail();
		}
	}
	
	// asignar
	@Test
	public void testAsignarNingunCliente() {
		Cliente cliente = new Cliente("Norman", 31, "Freire 432", cuenta1);
		assertTrue(cuenta1.pertenece(cliente));
	}
	
	@Test
	public void testAsignarUnCliente() {
		Cliente cliente = new Cliente("Norman", 91, "Freire 432", cuenta1);
		Cuenta cuenta2 = new CuentaCorriente("Euro", "Carlitos", 400);
		cuenta2.asignar(cliente);
		assertTrue(cuenta1.pertenece(cliente) && cuenta2.pertenece(cliente));
	}
	
	@Test
	public void testAsignarVariosClientes() {
		Cliente cliente = new Cliente("Norman", 15, "Freire 432", cuenta1);
		Cuenta cuenta2 = new CuentaCorriente("Euro", "Carlitos", 400);
		Cuenta cuenta3 = new CuentaCorriente("Euro", "Carlitos", 400);
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta2);
		cuentas.add(cuenta3);
		cliente.agregarCuenta(cuentas);
		assertTrue(cuenta1.pertenece(cliente) && cuenta2.pertenece(cliente) && cuenta3.pertenece(cliente));
	}

}
