package Parking;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) {

		
		Semaphore semaforo = new Semaphore(4);

		Coche coche1 = new Coche(semaforo, 100000, "SEAT","Ibiza");

		Coche coche2 = new Coche(semaforo, 5000, "FORD" ,"Fiesta");

		//Coche coche3 = new Coche(semaforo, 6000, "RENAULT Clio");

	//	Coche coche4 = new Coche(semaforo, 9000, "BMW S1");

		//Coche coche5 = new Coche(semaforo, 8000, "MERCEDES E240");


//		coche1.start();
//
//		coche2.start();
//
//		coche3.start();
//
//		coche4.start();
//
//
//
//		coche5.start();
	}

}
