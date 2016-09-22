package banco;

import java.util.Arrays;

abstract public class Cuenta {

	protected long saldo = 0;
	protected String moneda;
	protected String empresa;
	protected long numero;
	protected Cliente[] clientes;
	protected static long contador_cuentas = 0;
	private static final int MAX_CLIENTES = 10;
	
	public Cuenta(String moneda, String empresa) {
		if(empresa.equals(null) || moneda.equals(null)) return;
		this.clientes = new Cliente[MAX_CLIENTES];
		this.moneda = moneda;
		contador_cuentas++;
		this.numero = contador_cuentas;
	}
	
	// getters
	public long getSaldo() {
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

	public void retirar(long saldo) {
		if(saldo < 0) return;
		System.out.println("#"+this.numero+": Retirar = "+saldo+"\n");
		this.saldo -= saldo;
	}

	public void asignar(Cliente cliente) {
		if(cliente.equals(null)) return;
		System.out.println("#"+this.numero+": Asignar = "+cliente.getDni()+"\n");
		this.clientes = new Cliente[]{cliente};
	}
	
	public void asignar(Cliente[] clientes) {
		if(clientes.equals(null)) return;
		System.out.println("#"+this.numero+": Asignar varios clientes\n");
		this.clientes = clientes;
	}

	public boolean pertenece(Cliente cliente) {
		if(cliente.equals(null)) return false;
		System.out.println("#"+this.numero+": Pertenece = "+cliente.getDni()+"\n");
		return (Arrays.asList(clientes).contains(cliente));
	}
	
}