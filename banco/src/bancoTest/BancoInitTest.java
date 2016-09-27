package bancoTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.Banco;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class BancoInitTest {
	
	static CuentaCorriente cuentaCorriente;
	static CuentaSueldo cuentaSueldo;
	static Set<Cuenta> cuentas;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuentaCorriente = new CuentaCorriente("Dolar", "Epidata", 1000);
		cuentaSueldo = new CuentaSueldo("Euro", "Invgates");
		cuentas = new HashSet<Cuenta>();
		cuentas.add(cuentaSueldo);
		cuentas.add(cuentaCorriente);
	}
	
	@Test
	public void testInitSinCuenta() {
		Banco banco = new Banco();
		assertEquals(0, banco.getCuentas().size());
	}
	
	@Test
	public void testInitUnaCuenta() {
		Banco banco = new Banco(cuentaCorriente);
		assertEquals(1, banco.getCuentas().size());
	}
	
	@Test
	public void testInitVariasCuentas() {
		Banco banco = new Banco(cuentas);
		assertEquals(2, banco.getCuentas().size());
	}

}
