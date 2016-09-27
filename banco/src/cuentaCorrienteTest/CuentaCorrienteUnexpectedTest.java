package cuentaCorrienteTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import excepciones.SaldoInsuficienteException;

public class CuentaCorrienteUnexpectedTest {

private Cuenta cuenta1;
	
	@Before
	public void setUp() {
		cuenta1 = new CuentaCorriente("Dolar", "Epidata", 250);
	}
	
	// depositar
	@Test(expected=IllegalArgumentException.class)
	public void testDepositarNegativoSinSaldo() {
		cuenta1.depositar(-100);
		assertEquals(250, cuenta1.getSaldo(),0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDepositarNegativoConSaldo() {
		cuenta1.depositar(250);
		cuenta1.depositar(-100);
		assertEquals(500, cuenta1.getSaldo(),0);
	}
	
	// extraer
	@Test(expected=IllegalArgumentException.class)
	public void testExtraerNegativoSinSaldo() {
		try {
			cuenta1.extraer(-100);
		}
		catch (IllegalArgumentException e) {}
		catch (SaldoInsuficienteException e) {}
	}
	
	@Test(expected=SaldoInsuficienteException.class)
	public void testExtraerPasandoSaldoSinSaldo() {
		try {
			cuenta1.extraer(251);
		}
		catch (SaldoInsuficienteException e) {}	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExtraerNegativoConSaldo() {
		try {
			cuenta1.depositar(250);
			cuenta1.extraer(-100);
		}
		catch (IllegalArgumentException e) {}
		catch (SaldoInsuficienteException e) {}

	}
	
	@Test(expected=SaldoInsuficienteException.class)
	public void testExtraerPasandoSaldoConSaldo() {
		try {
			cuenta1.depositar(250);
			cuenta1.extraer(501);
		} catch (SaldoInsuficienteException e) {}
	}
	
	// asignar
	@Test
	public void testPerteneceCuentaNoAsignada() {
		Cuenta cuenta = new CuentaCorriente("Libra", "Galicia", 0);
		Cliente cliente = new Cliente("Norman", 81, "Freire 432", cuenta1);
		assertFalse(cuenta.pertenece(cliente));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAsignarClienteNull() {
		Cuenta cuenta = new CuentaCorriente("Libra", "Galicia", 0);
		Cliente cliente = null;
		cuenta.asignar(cliente);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAsignarClientesNull() {
		Cuenta cuenta = new CuentaCorriente("Libra", "Galicia", 0);
		Cliente cliente1 = null;
		Cliente cliente2 = null;
		Set<Cliente> clientes = new HashSet<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		cuenta.asignar(clientes);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAsignarClienteInputNull() {
		Cuenta cuenta = new CuentaCorriente("Libra", "Galicia", 0);
		new Cliente(null, 0, null, cuenta);
	}
	
}
