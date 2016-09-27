package clienteTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class ClienteExpectedTest {
	
	@Test
	public void testAgregarUnaCUenta() {
		Cuenta cuenta1 = new CuentaSueldo("Yen", "Lego");
		Cliente cliente = new Cliente("Norman", 81, "Muro 231", cuenta1);
		Cuenta cuenta0 = new CuentaCorriente("Euro", "Epidata", 0);
		cliente.agregarCuenta(cuenta0);
		assertEquals(2, cliente.getContCuentas());
	}
	
	@Test
	public void testAgregarDosCUentas() {
		Cuenta cuenta1 = new CuentaSueldo("Yen", "Lego");
		Cliente cliente = new Cliente("Norman", 66, "Muro 231", cuenta1);
		Cuenta cuenta0 = new CuentaCorriente("Euro", "Epidata", 0);
		Cuenta cuenta2 = new CuentaSueldo("Euro", "Bimbo");
		cliente.agregarCuenta(cuenta0);
		cliente.agregarCuenta(cuenta2);
		assertEquals(3, cliente.getContCuentas());
	}
	
	@Test
	public void testAgregarVariasCUentas() {
		Cuenta cuenta1 = new CuentaSueldo("Yen", "Lego");
		Cliente cliente = new Cliente("Norman", 91, "Muro 231", cuenta1);
		Cuenta cuenta0 = new CuentaCorriente("Euro", "Epidata", 0);
		Cuenta cuenta2 = new CuentaSueldo("Euro", "Bimbo");
		Set<Cuenta> cuentas = new HashSet<Cuenta>(Arrays.asList(cuenta2, cuenta0));
		cliente.agregarCuenta(cuentas);
		assertEquals(3, cliente.getContCuentas());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUnicidadClientes() {
		Cuenta cuenta1 = new CuentaSueldo("Yen", "Lego");
		new Cliente("Norman", 3, "Muro 231", cuenta1);
		new Cliente("Juan", 3, "Calle 22", cuenta1);
	}

}
