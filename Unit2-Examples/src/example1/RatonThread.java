package example1;

public class RatonThread extends Thread{

	private String nombre;
	private int tiempoAlimentacion;
	
	public RatonThread(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	@Override
	public void run() {
		comer();
	}
	
	public void comer() {
		try {
			System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);
			System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		
		for(int i=1; i<=5; i++) {
			RatonThread fievel = new RatonThread("Fievel", 4);
			fievel.setName("Hilo" + i);
			fievel.start();
		}
	}

}
