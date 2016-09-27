package clienteTest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaSueldo;

public class ClienteUnexpectedTest {
	
	@Test(expected=NullPointerException.class)
	public void testIniciarConInputNull() {
		Cuenta cuenta = new CuentaSueldo("Euro", "Mercadolibre");
		new Cliente(null, 0, null, cuenta);
	}
	
	@Test(expected=NullPointerException.class)
	public void testIniciarConCuentaNull() {
		Cuenta cuenta = null;
		new Cliente("Norman", 3, "Freire", cuenta);
	}
	
	@Test(expected=NullPointerException.class)
	public void testIniciarConCuentasNull() {
		Cuenta cuenta1 = null;
		Cuenta cuenta2 = null;
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		new Cliente("Norman", 3, "Freire", cuentas);
	}
	
	@Test(expected=NullPointerException.class)
	public void testIniciarConCuentaNullYNoNull() {
		Cuenta cuenta1 = new CuentaSueldo("Euro", "Jumbo");
		Cuenta cuenta2 = null;
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		new Cliente("Norman", 10, "Freire", cuentas);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarUnaCuentaNull() {
		Cuenta cuenta1 = new CuentaSueldo("Euro", "Jumbo");
		Cliente cliente = new Cliente("Norman", 5, "Freire", cuenta1);
		Cuenta cuenta2 = null;
		cliente.agregarCuenta(cuenta2);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarVariasCuentasNull() {
		Cuenta cuenta1 = new CuentaSueldo("Euro", "Jumbo");
		Cliente cliente = new Cliente("Norman", 15, "Freire", cuenta1);
		Cuenta cuenta2 = null;
		Cuenta cuenta3 = null;
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta2);
		cuentas.add(cuenta3);
		cliente.agregarCuenta(cuentas);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarUnaCuentaInputsNull() {
		Cuenta cuenta1 = new CuentaSueldo("Euro", "Jumbo");
		Cliente cliente = new Cliente("Norman", 1, "Freire", cuenta1);
		Cuenta cuenta2 = new CuentaSueldo(null, null);
		cliente.agregarCuenta(cuenta2);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarVariasCuentasInputsNull() {
		Cuenta cuenta1 = new CuentaSueldo("Euro", "Jumbo");
		Cliente cliente = new Cliente("Norman", 2, "Freire", cuenta1);
		Cuenta cuenta2 = new CuentaSueldo(null, null);
		Cuenta cuenta3 = new CuentaSueldo(null, null);
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta2);
		cuentas.add(cuenta3);
		cliente.agregarCuenta(cuentas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUnicidadClientes() {
		Cuenta cuenta1 = new CuentaSueldo("Yen", "Lego");
		new Cliente("Norman", 62, "Muro 231", cuenta1);
		new Cliente("Juan", 62, "Calle 22", cuenta1);
	}

}
