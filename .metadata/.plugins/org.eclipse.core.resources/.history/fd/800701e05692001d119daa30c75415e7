package ejemplo.sincronizacion;

public class main {

	public static void main(String[] args) {

		contador contador=new contador(100);
		HiloA a = new HiloA("HiloA",contador);
		HiloB b = new HiloB("HiloB",contador);
		
		a.start();
		b.start();
		
		
	}

}
