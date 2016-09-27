package bancoTest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import banco.Banco;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class BancoUnexpectedTest {

	Banco banco;
	
	@Before
	public void setUp() {
		banco = new Banco();
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarUnaCuentaNull() {
		Cuenta dummy = null;
		banco.agregarCuenta(dummy);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarVariasCuentasNull() {
		Cuenta cuenta1 = null;
		Cuenta cuenta2 = null;
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		banco.agregarCuenta(cuentas);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarUnaCuentaCamposNull() {
		Cuenta cuenta = new CuentaCorriente(null, null, 0);
		banco.agregarCuenta(cuenta);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAgregarVariasCuentasCamposNull() {
		Cuenta cuenta1 = new CuentaCorriente(null, null, 0);
		Cuenta cuenta2 = new CuentaSueldo(null, null);
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		banco.agregarCuenta(cuentas);
	}
	
	@Test(expected=NullPointerException.class)
	public void testIniciarCuentaCamposNull() {
		banco.crearCuentaCorriente(null, null, 0);
	}
	
	@Test(expected=NullPointerException.class)
	public void testIniciarCuentasCamposNull() {
		banco.crearCuentaCorriente(null, null, 0);
		banco.crearCuentaSaldo(null, null);
	}

}
