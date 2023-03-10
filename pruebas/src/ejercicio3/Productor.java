package ejercicio3;

public class Productor implements Runnable {
	private SinPila pila;
	private int id;
	private static int contador = 1;

	public Productor(SinPila p) {
		pila = p;
		id = contador++;

	}

	public void run() {
		char c;
		for (int i = 0; i < 200; i++) {
			c = (char) (Math.random() * 26 + 'A');
			pila.push(c);

			System.out.println("Productor " + id + " ha producido " + c);
			try {
				Thread.sleep((int) (Math.random() * 300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
