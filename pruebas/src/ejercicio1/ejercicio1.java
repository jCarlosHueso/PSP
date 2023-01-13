package ejercicio1;

public class ejercicio1 implements Runnable {

	private int numeroInicial;

	private int resultado;

	public ejercicio1() {

	}
	
	public ejercicio1(int numeroInicial) {

		this.numeroInicial = numeroInicial;

	}

	public void multiplicar() {

		//System.out.println("multiplicacion");

		resultado=numeroInicial*(int)Math.floor(Math.random()*10+1);
		
		for(int i = 7;i<10;i++) {
			System.out.println(Thread.currentThread().getName() +":  " 
		+ resultado+" * "+i+" = "+(resultado*i));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override

	public void run() {

		this.multiplicar();

	}

	public static void main(String[] args) {

		ejercicio1 ej1 = new ejercicio1(1);

		for (int i = 0; i < 10; i++) {

			new Thread(ej1).start();

		}

	}

}

