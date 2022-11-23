package waitnotify;

public class EjemploWaitNotify implements Runnable {

	public static Tenedor t = new Tenedor();
	public boolean comido;

	@Override
	public void run() {
		try {
			while (!comido) {
				synchronized (t) {
					if (!t.isEnPosesion()) {
						t.setEnPosesion(true);
						System.out.println(Thread.currentThread().getName() + " está comiendo");
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " ha terminado de comer");
						comido = true;
						t.setEnPosesion(false);
						t.notifyAll();
					} else {
						t.wait();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			EjemploWaitNotify ewn = new EjemploWaitNotify();

			Thread hilo = new Thread(ewn);
			hilo.setName("Comensal " + i);

			hilo.start();
		}
	}

}
