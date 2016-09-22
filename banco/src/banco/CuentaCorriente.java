package banco;

public class CuentaCorriente extends Cuenta {
	
	private long limite;
	
	public CuentaCorriente(String moneda, String empresa, long limite) {
		super(moneda, empresa);
		if(!(limite < 0) ) // TODO
			this.limite = limite;
	}

	public long getLimite() {
		return this.limite;
	}
	
	@Override
	public void retirar(double saldo) {
		if(this.getSaldo() + this.limite >= saldo)
			super.retirar(saldo);
	}
	
}
