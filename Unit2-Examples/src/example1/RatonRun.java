package example1;

public class RatonRun implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;
	
	public RatonRun(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
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
		RatonRun fievel = new RatonRun("Fievel", 4);
		RatonRun jerry = new RatonRun("Jerry", 5);
		RatonRun pinky = new RatonRun("Pinky", 3);
		RatonRun mickey = new RatonRun("Mickey", 6);
		
		new Thread(fievel).start();
		new Thread(jerry).start();
		new Thread(pinky).start();
		new Thread(mickey).start();
	}

	@Override
	public void run() {
		comer();	
	}
}
