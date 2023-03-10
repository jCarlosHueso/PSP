package ejercicio3;

public class Consumidor implements Runnable {
	private SinPila pila;
	private int id;
	private static int contador = 1;

	public Consumidor(SinPila p) {
		pila = p;
		id = contador++;
	}

	public void run() {
		char c;
		for (int i = 0; i < 200; i++) {
			c = pila.pop();
			System.out.println("Consumidor " + id + " ha consumido " + c);

			try {
				Thread.sleep((int) (Math.random() * 300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
