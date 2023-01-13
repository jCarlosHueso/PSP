package ejemplo2.Sincronizacion;

public class Cuenta  extends Thread{
private int saldo;


public Cuenta(int saldo) {
	this.saldo = saldo;
}


public int getSaldo() {
	return saldo;
	
}

public void restar(int cantidad) {
	saldo = saldo-cantidad;
}

public void restirarDinero(int cant,String nombre) {
	
	if(getSaldo()<0) {
		System.out.println("saldo negativo "+getSaldo());
	}
	
	if(getSaldo()>=cant) {
		System.out.println("se va a retirar salgo el actual es " + getSaldo());
		try {
			sleep(100);
		} catch (InterruptedException e) {
			
		}
		restar(cant);
		System.out.println(nombre+" Retira " + cant + " saldo actual " + getSaldo() );
	}else {
		System.out.println("no se pueden sacar perras, no hay\nSolo hay " + getSaldo());
	}
	
	
}

}
