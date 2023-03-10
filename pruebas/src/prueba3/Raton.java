package prueba3;

public class Raton implements Runnable{  



 	private String nombre;

 	private int tiempoAlimentacion;

 	

 	public Raton(String nombre, int tiempoAlimentacion) {

     	super();

     	this.nombre = nombre;

     	this.tiempoAlimentacion = tiempoAlimentacion;

 	}

 	

 	public void comer() {

     	try {

          	System.out.printf("El ratón %s ha comenzado a alimentarse%n",nombre);

          	Thread.sleep(tiempoAlimentacion*1000);

          	System.out.printf("El ratón %s ha terminado de alimentarse%n",nombre);

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

     	Raton almendra = new Raton("Almendra",5);

     	Raton cuky = new Raton("Cuky",4);

     	Raton ciro = new Raton("Ciro",5);

     	

     	new Thread(pop).start();

     	new Thread(almendra).start();

     	new Thread(cuky).start();

     	new Thread(ciro).start();

     	

 	}

 

}