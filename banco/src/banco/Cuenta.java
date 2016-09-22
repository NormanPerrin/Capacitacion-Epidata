package banco;

import java.util.HashSet;
import java.util.Set;

abstract public class Cuenta {

	private double saldo = 0;
	private String moneda;
	private String empresa;
	private long numero;
	private Set<Cliente> clientes = new HashSet<Cliente>();
	private static long contadorCuentas = 0;
	
	public Cuenta(String moneda, String empresa) {
		this.moneda = moneda;
		this.empresa = empresa;
		contadorCuentas++;
		this.numero = contadorCuentas;
	}
	
	// getters
	public double getSaldo() {
		return this.saldo;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public long getNumero() {
		return this.numero;
	}

	public long getNumeroCuentas() {
		return contadorCuentas;
	}
	
	public String getEmpresa() {
		return this.empresa;
	}
	
	// methods
	public void depositar(long monto) {
		this.saldo += monto;
	}

	public void extraer(double monto) {
		this.saldo -= monto;
	}

	public void asignar(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void asignar(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean pertenece(Cliente cliente) {
		return this.clientes.contains(cliente);
	}
	
}