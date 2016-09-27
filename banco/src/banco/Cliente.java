package banco;

import java.util.HashSet;
import java.util.Set;

import validaciones.Validacion;

public class Cliente {
	
	// state
	private String nombre;
	private int dni;
	private String dir;
	private Set<Cuenta> cuentas = new HashSet<Cuenta>();
	private int contCuentasCorrientes = 0;
	private int contCuentas = 0;
	private static Set<Integer> dnisSet = new HashSet<Integer>();
	
	// constructor
	public Cliente(String nombre, int dni, String dir, Set<Cuenta> cuentas) {
		boolean validacion = validarCuenta(cuentas) && validarCliente(dni);
		validacion = validacion && validarInputs(nombre, dir) && Validacion.validarNegativo(dni);
		if (validacion) {
			if (puedeAgregarCuenta(cuentas)) {
				this.nombre = nombre;
				this.dni = dni;
				this.dir = dir;
				this.cuentas.addAll(cuentas);
				dnisSet.add(dni);
				for (Cuenta cuenta : cuentas) {
					cuenta.asignar(this);
					actualizarContador(cuenta);
				}
			}
		}
	}

	public Cliente(String nombre, int dni, String dir, Cuenta cuenta) {
		if (validarCuenta(cuenta) && validarInputs(nombre, dir) && Validacion.validarNegativo(dni) && validarCliente(dni)) {
			if (puedeAgregarCuenta(cuenta)) { 
				this.nombre = nombre;
				this.dni = dni;
				this.dir = dir;
				this.cuentas.add(cuenta);
				dnisSet.add(dni);
				cuenta.asignar(this);
				actualizarContador(cuenta);
			}
		}
	}
	
	// getters
	public String getNombre() 				{return this.nombre;}
	public int getDni() 					{return this.dni;}
	public String getDir() 					{return this.dir;}
	public Set<Cuenta> getCuentas()			{return this.cuentas;}
	public int getContCuentasCorrientes()	{return this.contCuentasCorrientes;}
	public int getContCuentas()				{return this.contCuentas;}
	
	// methods
	public void agregarCuenta(Cuenta cuenta) {
		if (validarCuenta(cuenta)) {
			if (puedeAgregarCuenta(cuenta)) {
				this.cuentas.add(cuenta);
				cuenta.asignar(this);
				actualizarContador(cuenta);
			}
		}
	}
	
	public void agregarCuenta(Set<Cuenta> cuentas) {
		if(validarCuenta(cuentas)) {
			if (puedeAgregarCuenta(cuentas)) {
				this.cuentas.addAll(cuentas);
				for (Cuenta cuenta : cuentas) {
					cuenta.asignar(this);
				}
				actualizarContador(cuentas);
			}
		}
	}
	
	public boolean tieneCuenta(Cuenta cuenta) {
		return this.cuentas.contains(cuenta);
	}
	
	public boolean tieneCuenta(Set<Cuenta> cuentas) {
		for (Cuenta cuenta : cuentas) {
			if (!tieneCuenta(cuenta)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cliente) {
			return ((Cliente)obj).dni == this.dni;
		}
		return false;
	}
	
	// auxiliar methods
	private boolean puedeAgregarCuenta(Cuenta cuenta) {
		if (cuenta instanceof CuentaSueldo) 	return true;
		int contCuentaSueldo = this.contCuentas - this.contCuentasCorrientes;
		int contCorrientes = this.contCuentasCorrientes;
		if (tieneCuenta(cuenta)) contCorrientes--;
		if (contCorrientes + 1 <= contCuentaSueldo) return true;
		return false;
	}
	
	private boolean puedeAgregarCuenta(Set<Cuenta> cuentas) {
		int contCorriente = this.contCuentasCorrientes;
		int contSueldo = this.contCuentas - contCorriente;
		for (Cuenta cuenta : cuentas) {
			if (tieneCuenta(cuenta)) continue;
			if (cuenta instanceof CuentaSueldo) contCorriente++;
			else contSueldo++;
		}
		if(contCorriente <= contSueldo) return true;
		return false;
	}
	
	private void actualizarContador(Cuenta cuenta) {
		if(cuenta instanceof CuentaCorriente) {
			this.contCuentasCorrientes++;
		}
		this.contCuentas++;
	}
	
	private void actualizarContador(Set<Cuenta> cuentas) {
		for (Cuenta cuenta : cuentas) {
			actualizarContador(cuenta);
		}
	}
	
	private boolean validarCuenta(Cuenta cuenta) {
		boolean validacion = Validacion.validarObjNull(cuenta);
		if (validacion) {
			validacion = validacion && validarInputs(cuenta.getEmpresa(), cuenta.getMoneda());
		}
		return validacion;
	}
	
	private boolean validarCuenta(Set<Cuenta> cuentas) {
		boolean validacion = true;
		for (Cuenta cuenta : cuentas) {
			validacion = validacion && validarCuenta(cuenta);
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
	
	private boolean validarCliente(Integer dni) throws IllegalArgumentException {
		if (!dnisSet.contains(dni)) {
			return true;
		} else {
			throw new IllegalArgumentException("Numero de DNI usado");
		}
	}
	
}