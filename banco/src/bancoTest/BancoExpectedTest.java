package bancoTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import banco.Banco;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class BancoExpectedTest {
	
	static CuentaCorriente cuentaCorriente;
	static CuentaSueldo cuentaSueldo;
	static Set<Cuenta> cuentas;
	Banco banco;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuentaCorriente = new CuentaCorriente("Dolar", "Epidata", 1000);
		cuentaSueldo = new CuentaSueldo("Euro", "Invgates");
		cuentas = new HashSet<Cuenta>();
		cuentas.add(cuentaSueldo);
		cuentas.add(cuentaCorriente);
	}
	
	@Before
	public void setUp() {
		banco = new Banco();
	}
	
	@Test
	public void testAgregarUnaCuenta() {
		banco.agregarCuenta(cuentaCorriente);
		assertEquals(1, banco.getCuentas().size());
	}
	
	@Test
	public void testAgregarVariasCuentas() {
		banco.agregarCuenta(cuentas);
		assertEquals(2, banco.getCantidadCuentas());
	}
	
	@Test
	public void testIniciarCuenta() {
		Cuenta cuenta = banco.crearCuentaCorriente("Dolar", "Microsoft", 200);
		assertTrue(banco.contieneCuenta(cuenta));
	}
	
	@Test
	public void testIniciarCuentas() {
		Cuenta cuenta1 = banco.crearCuentaCorriente("Dolar", "Microsoft", 200);
		Cuenta cuenta2 = banco.crearCuentaSaldo("Yen", "Apple");
		assertTrue(banco.contieneCuenta(cuenta1) && banco.contieneCuenta(cuenta2));
	}
	
	@Test
	public void testCuentaMayorOrd1() {
		Cuenta cuenta1 = banco.crearCuentaCorriente("Dolar", "Microsoft", 200);
		Cuenta cuenta2 = banco.crearCuentaSaldo("Yen", "Apple");
		cuenta1.depositar(1000);
		cuenta2.depositar(2000);
		assertEquals(cuenta2, banco.getCuentaMayor());
	}
	
	@Test
	public void testCuentaMayorOrd2() {
		Cuenta cuenta2 = banco.crearCuentaSaldo("Yen", "Apple");
		Cuenta cuenta1 = banco.crearCuentaCorriente("Dolar", "Microsoft", 200);
		cuenta1.depositar(1000);
		cuenta2.depositar(2000);
		assertEquals(cuenta2, banco.getCuentaMayor());
	}
	
	@Test
	public void testTotal() {
		Cuenta cuenta2 = banco.crearCuentaSaldo("Yen", "Apple");
		Cuenta cuenta1 = banco.crearCuentaCorriente("Dolar", "Microsoft", 200);
		cuenta1.depositar(1000);
		cuenta2.depositar(2000);
		assertEquals(3200, banco.getTotal(),0);
	}
	
}
