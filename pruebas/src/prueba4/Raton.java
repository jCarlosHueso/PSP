package prueba4;

public class Raton implements Runnable{

 	

 	private String nombre;

 	private int tiempoAlimentacion;

 	private int alimentoConsumido;

 	

 	public Raton(String nombre, int tiempoAlimentacion) {

     	super();

     	this.nombre = nombre;

     	this.tiempoAlimentacion = tiempoAlimentacion;

 	}

 	

 	public void comer() {

     	try {

          	System.out.printf("El ratón %s ha comenzado a alimentarse%n",nombre);

          	Thread.sleep(tiempoAlimentacion*1000);

          	alimentoConsumido++;

          	System.out.printf("El ratón %s ha terminado de alimentarse%n",nombre);

          	System.out.printf("Alimento consumido:%d%n", alimentoConsumido);

     	}catch (InterruptedException e) {

          	e.printStackTrace();

     	}

 	}

 	

 	@Override

 	public void run() {

     	this.comer();

 	}

 	

 	public static void main(String[] args) {

     	Raton pop = new Raton("Pop",4);

     	

     	new Thread(pop).start();

     	new Thread(pop).start();

     	new Thread(pop).start();

     	new Thread(pop).start();

     	

 	}

 	

}