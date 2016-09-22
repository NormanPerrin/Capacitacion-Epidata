package banco;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private String nombre;
	private int dni;
	private String dir;
	private Set<Cuenta> cuentas = new HashSet<Cuenta>();

	public Cliente(String nombre, int dni, String dir, Set<Cuenta> cuentas) {
		this.nombre = nombre;
		this.dni = dni; 
		this.dir = dir;
		this.cuentas.addAll(cuentas);
		for (Cuenta cuenta : cuentas) {
			cuenta.asignar(this);
		}
		
	}

	public Cliente(String nombre, int dni, String dir, Cuenta cuenta) {
		this.nombre = nombre;
		this.dni = dni;
		this.dir = dir;
		this.cuentas.add(cuenta);
		cuenta.asignar(this);
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getDni() {
		return this.dni;
	}

	public String getDir() {
		return this.dir;
	}

	public HashSet<Cuenta> getCuentas() {
		return (HashSet<Cuenta>) this.cuentas;
	}
	
}