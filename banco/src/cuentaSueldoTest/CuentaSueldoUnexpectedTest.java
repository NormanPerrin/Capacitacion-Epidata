package cuentaSueldoTest;

import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaSueldo;
import excepciones.SaldoInsuficienteException;

public class CuentaSueldoUnexpectedTest {
	
	Cuenta cuenta1;
	
	@Before
	public void setUp() {
		cuenta1 = new CuentaSueldo("Dolar", "Epidata");
	}
	
	// depositar
	@Test(expected=IllegalArgumentException.class)
	public void testDepositarNegativoSinSaldo() {
		cuenta1.depositar(-100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDepositarNegativoConSaldo() {
		cuenta1.depositar(250);
		cuenta1.depositar(-100);
	}
	
	// extraer
	@Test(expected=IllegalArgumentException.class)
	public void testExtraerNegativoSinSaldo() {
		try {
			cuenta1.extraer(-100);
		} catch (SaldoInsuficienteException e) {}
	}
	
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
			cuenta1.extraer(251);
		} catch (SaldoInsuficienteException e) {}
	}
	
	// asignar
	@Test
	public void testPerteneceCuentaNoAsignada() {
		Cuenta cuenta = new CuentaSueldo("Libra", "Galicia");
		Cliente cliente = new Cliente("Norman", 91, "Freire 432", cuenta1);
		assertFalse(cuenta.pertenece(cliente));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAsignarClienteNull() {
		Cuenta cuenta = new CuentaSueldo("Libra", "Galicia");
		Cliente cliente = null;
		cuenta.asignar(cliente);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAsignarClientesNull() {
		Cuenta cuenta = new CuentaSueldo("Libra", "Galicia");
		Cliente cliente1 = null;
		Cliente cliente2 = null;
		Set<Cliente> clientes = new HashSet<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		cuenta.asignar(clientes);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAsignarClienteInputNull() {
		Cuenta cuenta = new CuentaSueldo("Libra", "Galicia");
		new Cliente(null, 0, null, cuenta);
	}

}
