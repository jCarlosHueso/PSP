package ejemplo.sincronizacion;

public class HiloBSinc extends Thread {

	private contador contador;

	public HiloBSinc(String n, contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int i = 0; i < 300; i++) {
				contador.decrementa();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("error catch b");
			}
			System.out.println(getName() + " Contador vale " + contador.getValor());
		}
	}
}
