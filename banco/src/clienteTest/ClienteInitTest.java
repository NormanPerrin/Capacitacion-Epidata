package clienteTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class ClienteInitTest {
	
	private static CuentaCorriente cuenta1;
	private static CuentaSueldo cuenta2;
	private static Set<Cuenta> cuentas;
	private static Cliente cliente2;
	private static Cliente cliente1;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cuenta1 = new CuentaCorriente("Euro", "Epidata", 0);
		cuenta2 = new CuentaSueldo("Yen", "Lego");
		cuentas = new HashSet<Cuenta>(Arrays.asList(cuenta2, cuenta1));
		cliente2 = new Cliente("Norman", 3, "Muro 231", cuentas);
		cliente1 = new Cliente("Juan", 5, "Florida 173", cuenta1);
	}
	
	@Test
	public void testNombre() {
		assertEquals("Norman", cliente2.getNombre());
	}
	
	@Test
	public void testDni() {
		assertEquals(3, cliente2.getDni());
	}
	
	@Test
	public void testDir() {
		assertEquals("Muro 231", cliente2.getDir());
	}
	
//	@Test
//	public void testUnaCuenta() {
//		assertEquals(new HashSet<Cuenta>(Arrays.asList(cuenta2)), cliente1.getCuentas());
//	}
	
	@Test
	public void testVariasCuenta() {
		assertEquals(cuentas, cliente2.getCuentas());
	}
	
}
