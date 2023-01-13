package ejemplo.sincronizacion;

public class contador {

private int c=0;

public contador(int c) {
this.c = c;
}

public void incrementa() {
	c++;
}
public void decrementa() {
	c--;
}
public int getValor() {
	return c;
}

}
