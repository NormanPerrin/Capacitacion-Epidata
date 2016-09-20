
public class Fibo {
	
	int[] calcular(int n) {
		
		// validaciones
		if (n < 0) return null;
		
		// casos base
		if (n == 0) return (new int[]{0});
		if (n == 1) return (new int[]{0, 1});
		
		// casos normales
		int[] resp = new int[n+1];
		resp[0] = 0;
		resp[1] = 1;
		
		for (int i = 1; i < n; i++) {
			// size validation
			long temporal_value = resp[i-1] + resp[i];
			if (temporal_value > Integer.MAX_VALUE) return null;
			resp[i+1] = resp[i-1] + resp[i];
		}
		
		return resp;
	}
	
}
