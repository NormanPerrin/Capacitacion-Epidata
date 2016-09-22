package banco;

public class Cliente {

	private String nombre;
	private int dni;
	private String dir;
	private Cuenta[] cuentas;

	public Cliente(String nombre, int dni, String dir, Cuenta[] cuentas) {
		if(dni < 0 || nombre.equals(null) || dir.equals(null) || cuentas.equals(null)) return;
		this.nombre = nombre;
		this.dni = dni;
		this.dir = dir;
		this.cuentas = cuentas;
		for(int i = 0; i < cuentas.length; i++)
			cuentas[i].asignar(this);
	}

	public Cliente(String nombre, int dni, String dir, Cuenta cuenta) {
		if(dni < 0 || nombre.equals(null) || dir.equals(null) || cuenta.equals(null)) return;
		this.nombre = nombre;
		this.dni = dni;
		this.dir = dir;
		this.cuentas = new Cuenta[]{cuenta};
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

	public Cuenta[] getCuentas() {
		return this.cuentas;
	}
	
}