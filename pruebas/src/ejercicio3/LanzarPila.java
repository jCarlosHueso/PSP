package ejercicio3;

public class LanzarPila {

	public static void main(String[] args) {
		
		
		SinPila pila = new SinPila();
		
		Productor p1 = new Productor(pila);
		Thread p1h1 = new Thread(p1);
		p1h1.start();
		
		Productor p2 = new Productor(pila);
		Thread p2h2 = new Thread(p2);
		p2h2.start();
		
		Consumidor c1 = new Consumidor(pila);
		Thread c1h1 = new Thread(c1);
		c1h1.start();
		
		Consumidor c2 = new Consumidor(pila);
		Thread c2h2 = new Thread(c2);
		c2h2.start();
	}
	
	
}
