package app.AFD;

/**
 * Clase Transiciones: Se encarga de almacenar las funciones de transiciones de
 * cada estado
 */

public class Transiciones {
	//Simbolo de la transicion
	public String simbolo;
	//Estado al que envia la transicion
	int Estado;

	// Constructor
	public Transiciones(String sigma, int to) {
		this.simbolo = sigma;
		this.Estado = to;
	}

	// Getters and Setters
	public int getValor() {
		return Estado;
	}

	public void setValor(int valor) {
		this.Estado = valor;
	}

	public String getSigma() {
		return simbolo;
	}

	public void setSigma(String sigma) {
		this.simbolo = sigma;
	}

	public String toString() {
		return " Sigma: " + this.simbolo + " Valor: " + this.Estado;
	}

}
