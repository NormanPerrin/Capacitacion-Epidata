package banco;

import java.util.HashSet;
import java.util.Set;

import validaciones.Validacion;

public class Banco {
	
	// state
	private Set<Cuenta> cuentas = new HashSet<Cuenta>();
	
	// constructor
	public Banco() {}
	public Banco(Cuenta cuenta)			{this.agregarCuenta(cuenta);}
	public Banco(Set<Cuenta> cuenta)	{this.agregarCuenta(cuenta);}

	// mothods
	public void agregarCuenta(Cuenta cuenta) {
		if (validarCuenta(cuenta)) {
			this.cuentas.add(cuenta);
		}
	}
	public void agregarCuenta(Set<Cuenta> cuentas)	{
		boolean validacion = true;
		for (Cuenta cuenta : cuentas) {
			validacion = validacion && validarCuenta(cuenta);
		}
		if (validacion) {
			this.cuentas.addAll(cuentas);
		}
	}
	
	public Cuenta crearCuentaSaldo(String moneda, String empresa) {
		if (validarInputs(moneda, empresa)) {
			Cuenta cuenta = new CuentaSueldo(moneda, empresa);
			cuentas.add(cuenta);
			return cuenta;
		}
		return null;
	}
	
	public Cuenta crearCuentaCorriente(String moneda, String empresa, double limite) {
		if (validarInputs(moneda, empresa) && Validacion.validarNegativo(limite)) {
			Cuenta cuenta = new CuentaCorriente(moneda, empresa, limite);
			cuentas.add(cuenta);
			return cuenta;		
		}
		return null;		
	}
	
	public boolean contieneCuenta(Cuenta cuenta) {
		return this.cuentas.contains(cuenta);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Banco) {
			return ((Banco)obj).getCuentas().equals(this.cuentas);
		}
		return false;
	}
	
	// getters
	public Set<Cuenta> getCuentas()	{return this.cuentas;}
	public int getCantidadCuentas() {return this.cuentas.size();}
	
	public Cuenta getCuentaMayor() {
		double mayorSaldo = 0;
		Cuenta mayorCuenta = null;
		for (Cuenta cuenta : this.cuentas) {
			double saldo = cuenta.getSaldo();
			if (saldo > mayorSaldo) {
				mayorSaldo = saldo;
				mayorCuenta = cuenta;
			}
		}
		return mayorCuenta;
	}
	
	public double getTotal() {
		double total = 0;
		for (Cuenta cuenta : this.cuentas) {
			total += cuenta.getSaldo();
		}
		return total;
	}
	
	// auxiliar methods
	private boolean validarCuenta(Cuenta cuenta) {
		boolean validacion = Validacion.validarObjNull(cuenta);
		if (validacion) {
			validacion = validacion && validarInputs(cuenta.getEmpresa(), cuenta.getMoneda());
		}
		return validacion;
	}
	
	private boolean validarInputs(String str1, String str2) {
		boolean validacion = true;
		validacion = validacion && Validacion.validarObjNull(str1);
		validacion = validacion && Validacion.validarObjNull(str2);
		validacion = validacion && Validacion.validarStringVacio(str1);
		validacion = validacion && Validacion.validarStringVacio(str2);
		return validacion;
	}

}
