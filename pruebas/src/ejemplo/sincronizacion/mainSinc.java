package ejemplo.sincronizacion;

public class mainSinc {

	public static void main(String[] args) {

		contador contador=new contador(100);
		HiloASinc a = new HiloASinc("HiloA",contador);
		HiloBSinc b = new HiloBSinc("HiloB",contador);
		
		a.start();
		b.start();
		
		
	}

}
