package banco;

import java.util.HashSet;
import java.util.Set;

public class Banco {
	
	private double total = 0;
	private Cuenta cuentaMayor;
	private Set<Cuenta> cuentas = new HashSet<Cuenta>();
	
	public void agregarCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
		this.total += cuenta.getSaldo();
	}
	
	public void agregarCuentas(HashSet<Cuenta> cuentas) {
		this.cuentas.addAll(cuentas);
		for(Cuenta cuenta : cuentas) {
			total += cuenta.getSaldo();
		}
	}
	
	public Cuenta getMayor() {
		return this.cuentaMayor;
	}
	
	public double getTotal() {
		return total;
	}
	
	
	
	
	
}
