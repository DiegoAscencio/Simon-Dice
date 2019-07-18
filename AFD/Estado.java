package app.AFD;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Estado: Esta clase se encarga de almacenar estados con su numero y sus
 * transiciones
 */

public class Estado {

	// Numero de estado
	private int numeroDeEstado;
	// Lista que contiene las transiciones del estado
	private List<Transiciones> transiciones;

	// Constructor que recibe el numero de estado
	public Estado(int est) {
		setNumeroDeEstado(est);
		transiciones = new ArrayList<Transiciones>();
	}

	public void setNumeroDeEstado(int numeroDeEstado) {
		this.numeroDeEstado = numeroDeEstado;
	}

	public int getNumeroDeEstado() {
		return numeroDeEstado;
	}

	public List<Transiciones> getTransiciones() {
		return transiciones;
	}

	public void setTransiciones(List<Transiciones> transiciones) {
		this.transiciones = transiciones;
	}

	public void addTransition(String sigma, int valor) {
		this.transiciones.add(new Transiciones(sigma, valor));
	}

	public void getTransitionAt(int i) {
		this.transiciones.get(i);
	}
}