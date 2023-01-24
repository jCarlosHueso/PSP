package Parking;

import java.util.concurrent.Semaphore;

public class Coche {

	private int tiempoEspeara;
	private String marca;
	private String modelo;
	private Semaphore semaforo;
	public Coche() {
	}
	public Coche( Semaphore semaforo, int tiempoEspeara, String marca, String modelo) {
		this.tiempoEspeara = tiempoEspeara;
		this.marca = marca;
		this.modelo = modelo;
		this.semaforo = semaforo;
	}
	public int getTiempoEspeara() {
		return tiempoEspeara;
	}
	public void setTiempoEspeara(int tiempoEspeara) {
		this.tiempoEspeara = tiempoEspeara;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Semaphore getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	
}
