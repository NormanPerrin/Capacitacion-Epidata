package clienteTest;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;

public class ClienteInitTest {
	
	private CuentaSueldo cuenta2 = new CuentaSueldo("Dolar", "Evil Corp");
	private CuentaCorriente cuenta1 = new CuentaCorriente("Euro", "Epidata", 0);
	private CuentaCorriente cuenta0 = new CuentaCorriente("Yen", "Lego", 0);
	private Cuenta[] cuentas = new Cuenta[]{cuenta0, cuenta1, cuenta2}; // TODO
	private Cliente cliente2 = new Cliente("Norman", 3, "Muro 231", cuentas);
	private Cliente cliente1 = new Cliente("Juan", 5, "Florida 173", cuenta1);
	
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
	
	@Test
	public void testCuenta() {
		assertArrayEquals(new Cuenta[]{cuenta1}, cliente1.getCuentas()); // TODO
	}
	
	@Test
	public void testCuentas() {
		assertArrayEquals(cuentas, cliente2.getCuentas()); // TODO
	}
	
}
