package ejemplo.sincronizacion;

public class HiloB extends Thread{

	private contador contador;
	
	public HiloB(String n,contador c) {
		setName(n);
		contador=c;
	}
	
	public void run() {
	for (int i = 0; i < 300; i++) {
	contador.decrementa();	
	}	
	try{
		sleep(100);
	}catch(InterruptedException e) {
		System.out.println("error catch b");
	}
	System.out.println(getName() + " Contador vale " + contador.getValor());

	}
	
}
