package banco;

public class CuentaCorriente extends Cuenta {
	
	private long limite;
	
	public CuentaCorriente(String moneda, String empresa, long limite) {
		super(moneda, empresa);
		if(limite < 0) return;
		this.limite = limite;
	}

	public long getLimite() {
		return this.limite;
	}
	
	@Override
	public void retirar(long saldo) {
		if(this.saldo + this.limite >= saldo)
			super.retirar(saldo);
	}
	
}
