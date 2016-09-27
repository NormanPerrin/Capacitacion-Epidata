package banco;

import java.util.HashSet;
import java.util.Set;

import excepciones.SaldoInsuficienteException;
import validaciones.Validacion;

abstract public class Cuenta {
	
	// state
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
	public double getSaldo() 		{return this.saldo;}
	public String getMoneda() 		{return this.moneda;}
	public String getEmpresa() 		{return this.empresa;}
	public long getNumero() 		{return this.numero;}
	public long getNumeroCuentas() 	{return contadorCuentas;}
	
	// methods
	public void depositar(double monto) {
		if (Validacion.validarNegativo(monto)) {
			this.actualizarSaldo(monto);
		}
	}

	public void extraer(double monto) throws SaldoInsuficienteException {
		if (Validacion.validarNegativo(monto)) {
			if(this.getSaldo() >= monto) {
				this.actualizarSaldo(-monto);
			} else {
				throw new SaldoInsuficienteException("Saldo insuficiente:");
			}
		}
	}

	public void asignar(Cliente cliente) {
		if (Validacion.validarObjNull(cliente)) {
			this.clientes.add(cliente);
		}
	}
	
	public void asignar(Set<Cliente> clientes) {
		if (Validacion.validarObjNull(clientes.toArray())) {
			this.clientes.addAll(clientes);
		}
	}

	public boolean pertenece(Cliente cliente) {
		return this.clientes.contains(cliente);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cuenta) {
			return ((Cuenta)obj).getNumero() == this.numero;
		}
		return false;
	}
	
	// auxiliar methods
	private void actualizarSaldo(double monto) {
		this.saldo += monto;
	}
	
}