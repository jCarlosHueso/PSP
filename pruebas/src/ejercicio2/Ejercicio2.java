package ejercicio2;

public class Ejercicio2 implements Runnable {
	private int contador = 0;

	public Ejercicio2() {

	}

	public static void main(String[] args) {

//		Realice un ejercicio que crea 3 hilos y
//		que cada uno de ellos vaya mostrando el contenido de un contador.
		Ejercicio2 ej2 = new Ejercicio2();
		for (int i = 0; i < 3; i++) {
			System.out.println("contador " + i);
			new Thread(ej2).start();

		}

	}

	@Override
	public void run() {
		this.contador();
	}

	public void contador() {
		for (int i = 0; i < 5; i++) {
			contador++;
			System.out.println(contador);
		}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
