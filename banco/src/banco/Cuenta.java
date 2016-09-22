package banco;

import java.util.Arrays;
import java.util.Set;

abstract public class Cuenta {

	private double saldo = 0; // TODO agregar get todos + métodos auxiliares
	private String moneda;
	private String empresa;
	private long numero;
	private Set<Cliente> clientes = new Set<Cliente>(); // TODO
	private static long contador_cuentas = 0;
	
	public Cuenta(String moneda, String empresa) {
		if(empresa.equals(null) || moneda.equals(null)) return;
		this.moneda = moneda;
		contador_cuentas++;
		this.numero = contador_cuentas;
	}
	
	// getters
	public double getSaldo() {
		System.out.println("#"+this.numero+": Ver saldo = "+this.saldo+"\n");
		return this.saldo;
	}

	public String getMoneda() {
		System.out.println("#"+this.numero+": Ver moneda = "+this.moneda+"\n");
		return this.moneda;
	}

	public long getNumero() {
		System.out.println("#"+this.numero+": Ver numero = "+this.numero+"\n");
		return this.numero;
	}

	public long getNumeroCuentas() {
		System.out.println("#"+this.numero+": Ver numero cuentas = "+contador_cuentas+"\n");
		return contador_cuentas;
	}
	
	// methods
	public void depositar(long saldo) {
		if(saldo < 0) return;
		System.out.println("#"+this.numero+": Depositar = "+saldo+"\n");
		this.saldo += saldo;
	}

	public void retirar(double monto) {
		if(monto < 0) return;
		System.out.println("#"+this.numero+": Retirar = "+monto+"\n");
		this.saldo -= saldo;
	}

	public void asignar(Cliente cliente) {
		if(cliente.equals(null)) return;
		System.out.println("#"+this.numero+": Asignar = "+cliente.getDni()+"\n");
		this.clientes.add(cliente);
	}
	
	public void asignar(Set<Cliente> clientes) {
		if(clientes.equals(null)) return;
		System.out.println("#"+this.numero+": Asignar varios clientes\n");
		this.clientes = clientes;
	}

	public boolean pertenece(Cliente cliente) {
		if(cliente.equals(null)) return false;
		System.out.println("#"+this.numero+": Pertenece = "+cliente.getDni()+"\n");
		return (this.clientes.contains(cliente)); // TODO
	}
	
}