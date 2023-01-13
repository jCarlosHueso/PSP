package ejemplo.sincronizacion;

public class HiloASinc extends Thread {

	private contador contador;

	public HiloASinc(String n, contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int i = 0; i < 300; i++) {
				contador.incrementa();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("error catch a");
			}
			System.out.println(getName() + " Contador vale " + contador.getValor());
		}
	}
}
