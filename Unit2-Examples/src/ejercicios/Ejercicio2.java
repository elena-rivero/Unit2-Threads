package ejercicios;

public class Ejercicio2 extends Thread{

	public static int numeroAdivinar;
	public static boolean acertado = false;
	
	@Override
	public void run() {
		int numero = (int) Math.random();
		int res = propuestaNumero(numero);
		
		while (res ==0) {
			numero = (int) Math.random();
			res = propuestaNumero(numero);
		}
		// interrumpir en cualquier caso
	}
	
	
	public static int propuestaNumero(int numero) {
		int res = 0;
		if(numero==numeroAdivinar) {
			res = 1;
			// Interrumpir el hilo
		} 
		if(acertado) {
			res = -1;
			// Interrumpir el hilo
		}
		return res;
	}
	
	public static void main(String[] args) {
		numeroAdivinar = (int) Math.random();
		for(int i=1; i<=10;i++) {
			new Ejercicio2().start();
		}

	}

}
