package ejemplo2.Sincronizacion;

public class Cliente extends Thread{

	private Cuenta c;
	
	public Cliente(String nombre,Cuenta c) {
		super(nombre);
	}
	public void run() {
		for (int i = 0; i <4 ; i++) {
			c.restirarDinero(10, getName());
		}
	}
	
}
