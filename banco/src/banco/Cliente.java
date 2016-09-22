package banco;

import java.util.Iterator;
import java.util.Set;

public class Cliente { // TODO hacer metodos auxilares para limpiar todo

	private String nombre;
	private int dni;
	private String dir;
	private Set<Cuenta> cuentas = new Set<Cuenta>() { // TODO
	};

	public Cliente(String nombre, int dni, String dir, Set<Cuenta> cuentas) {
		if(dni < 0 || nombre.equals(null) || dir.equals(null) || cuentas.equals(null)) return;
		this.nombre = nombre;
		this.dni = dni;
		this.dir = dir;
		this.cuentas.add((Cuenta) cuentas);
		Iterator<Cuenta> iterator = cuentas.iterator();
		while(iterator.hasNext()) {
			this.cuentas.add((Cuenta) iterator);
		}
	}

	public Cliente(String nombre, int dni, String dir, Cuenta cuenta) {
		if(dni < 0 || nombre.equals(null) || dir.equals(null) || cuenta.equals(null)) return;
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

	public Set<Cuenta> getCuentas() {
		return this.cuentas;
	}
	
}