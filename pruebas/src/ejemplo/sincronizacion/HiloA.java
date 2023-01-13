package ejemplo.sincronizacion;

public class HiloA extends Thread{

	
	private contador contador;
	
	public HiloA(String n,contador c) {
		setName(n);
		contador=c;
	}
	
	public void run() {
	for (int i = 0; i < 300; i++) {
	contador.incrementa();	
	}	
	try{
		sleep(100);
	}catch(InterruptedException e) {
		System.out.println("error catch a");
	}
	System.out.println(getName() + " Contador vale " + contador.getValor());

	}
	
}
