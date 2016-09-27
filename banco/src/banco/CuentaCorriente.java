package banco;

public class CuentaCorriente extends Cuenta {
	
	// state
	private double limite;
	
	// constructor
	public CuentaCorriente(String moneda, String empresa, double limite) {
		super(moneda, empresa);
		if(!(limite < 0)) {
			this.limite = limite;
		}
	}
	
	// getters
	public double getLimite() {
		return this.limite;
	}
	
	@Override
	public double getSaldo() {
		return super.getSaldo() + this.limite;
	}
	
}
