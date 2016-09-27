package validaciones;

public class Validacion {
	
	// constructor
	private Validacion(){}
	
	// methods
	public static boolean validarNegativo(double numero) throws IllegalArgumentException {
		if (numero < 0) {
			throw new IllegalArgumentException("Valor negativo");
		}
		return true;
	}
	
	public static boolean validarObjNull(Object obj) throws NullPointerException {
		if (obj == null) {
			throw new NullPointerException("Objeto null");
		}
		return true;
	}
	
	public static boolean validarObjNull(Object[] objs) throws NullPointerException, IllegalArgumentException {
		if (objs.length == 0) {
			throw new IllegalArgumentException("Array vacio");
		}
		boolean validacion = true;
		for (Object object : objs) {
			validacion = validacion && validarObjNull(object);
		}
		if (validacion) {
			return true;
		} else {
			throw new NullPointerException("Objeto null");
		}
	}
	
	public static boolean validarStringVacio(String str) throws IllegalArgumentException {
		if (str.equals("")) {
			throw new IllegalArgumentException("String vacío");
		}
		return true;
	}
	
	public static boolean validarStringVacio(String[] strs) throws NullPointerException, IllegalArgumentException {
		if (strs.length == 0) {
			throw new IllegalArgumentException("Array vacío");
		}
		boolean validacion = true;
		for (String str : strs) {
			validacion = validacion && validarStringVacio(str);
		}
		if (validacion) {
			return true;
		} else {
			throw new NullPointerException("Objeto null");
		}
	}

}
