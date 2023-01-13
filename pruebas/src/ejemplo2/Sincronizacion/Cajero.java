package ejemplo2.Sincronizacion;

public class Cajero {

	public static void main(String[] args) {

		Cuenta c = new Cuenta(40);
		Cliente h1 = new Cliente("ana",c);
		Cliente h2 = new Cliente("Diego",c);
	}

}
