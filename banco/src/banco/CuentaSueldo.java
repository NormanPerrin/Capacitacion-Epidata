package banco;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(String moneda, String empresa) {
		super(moneda, empresa);
	}
	
	@Override
	public void retirar(long saldo) {
		if(this.saldo >= saldo)
			super.retirar(saldo);
	}

}
