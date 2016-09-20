package calculadora;

public class Calculadora {
	
	int ultimoResultado;
	
	Calculadora(int valor) {
		ultimoResultado = valor;
	}
	
	int suma(int num1, int num2) {
		ultimoResultado = num1 + num2;
		return ultimoResultado;
	}

	int getUltimoResultado() {
		return ultimoResultado;
	}
	
	
	
}
