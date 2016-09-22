package banco;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(String moneda, String empresa) {
		super(moneda, empresa);
	}
	
	@Override
	public void extraer(double saldo) {
		if(this.getSaldo() >= saldo)
			super.extraer(saldo);
	}

}
