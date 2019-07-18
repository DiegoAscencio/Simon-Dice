package app;

import java.util.ArrayList;

import app.AFD.Estado;

/**
 * Clase AFD_Patrones: Esta clase almacena los automatas definidos para cada
 * nivel, ademas de generar las animaciones de los patrones, revisar las
 * entradas y terminar el juego
 */

public class AFD_Patrones {
	// AUTOMATA FINITO DETERMINISTA
	// Variable que tomara el automata dependiendo del nivel
	Estado[] AFD;
	// El estado actual del automata
	int estadoActual;
	// Se activa cuando llegamos al estado final
	private boolean estadoFinal;
	// Se activa cuando entramos en estado de error
	private boolean estadoError;

	// ANIMACION DE LOS RECTANGULOS DE COLORES
	// Aqui se almacena el patron que se va a iluminar
	String[] patronIlumniar;
	// Con este entero se iteran los colores que se van a iluminar
	private int indexPatron;
	// Con este entero interactuan los clicks del usuario y el patron a iluminar
	private int indexPresionado;
	// Esta lista envia que rectangulos encender al metodo resaltar patron
	private ArrayList<String> secuencia_iluminar;

	// CONTROL DEL JUEGO
	// Boolean que determina si el juego esta activo
	private boolean activo;
	// Entero que almacena el nivel actual
	private int nivel;

	// Constructor del objeto, comienza en el estado incial q0, el juego esta
	// inactivo , no estamos en estado final ni en estado de error
	public AFD_Patrones() {
		secuencia_iluminar = new ArrayList<String>();
		setActivo(false);
		setEstadoFinal(false);
		setEstadoError(false);
	}

	// Esta clase se encarga de seleccionar el patron de cada nivel y cargarlo
	// al AFD
	public void cargarAFD(int nivel) {
		setEstadoFinal(false);
		setEstadoError(false);
		setActivo(true);
		this.nivel = nivel;
		estadoActual = 0;
		indexPresionado = 0;
		indexPatron = 0;
		// En caso de que se haya jugado una partida anterior limpiamos la
		// secuencia que ilumina
		secuencia_iluminar.clear();

		switch (nivel) {
		case 1:
			// Patron que debe serguir la iluminacion
			String[] patron1 = { "g", "r", "y" };
			patronIlumniar = patron1;

			// Automata Finito Determinista del nivel 1
			AFD = new Estado[8];
			AFD[0] = new Estado(0);
			AFD[0].addTransition("g", 1);
			AFD[0].addTransition("r", 7);
			AFD[0].addTransition("y", 7);
			AFD[0].addTransition("b", 7);

			AFD[1] = new Estado(1);
			AFD[1].addTransition("g", 2);
			AFD[1].addTransition("r", 7);
			AFD[1].addTransition("y", 7);
			AFD[1].addTransition("b", 7);

			AFD[2] = new Estado(2);
			AFD[2].addTransition("g", 7);
			AFD[2].addTransition("r", 3);
			AFD[2].addTransition("y", 7);
			AFD[2].addTransition("b", 7);

			AFD[3] = new Estado(3);
			AFD[3].addTransition("g", 4);
			AFD[3].addTransition("r", 7);
			AFD[3].addTransition("y", 7);
			AFD[3].addTransition("b", 7);

			AFD[4] = new Estado(4);
			AFD[4].addTransition("g", 7);
			AFD[4].addTransition("r", 5);
			AFD[4].addTransition("y", 7);
			AFD[4].addTransition("b", 7);

			AFD[5] = new Estado(5);
			AFD[5].addTransition("g", 7);
			AFD[5].addTransition("r", 7);
			AFD[5].addTransition("y", 6);
			AFD[5].addTransition("b", 7);

			AFD[6] = new Estado(6);
			AFD[6].addTransition("g", 6);
			AFD[6].addTransition("r", 6);
			AFD[6].addTransition("y", 6);
			AFD[6].addTransition("b", 6);

			AFD[7] = new Estado(7);
			AFD[7].addTransition("g", 7);
			AFD[7].addTransition("r", 7);
			AFD[7].addTransition("y", 7);
			AFD[7].addTransition("b", 7);
			break;

		case 2:
			// Patron que debe serguir la iluminacion
			String[] patron2 = { "g", "r", "y", "b", "b", "y" };
			patronIlumniar = patron2;

			// Automata Finito Determinista del nivel 2
			AFD = new Estado[14];
			AFD[0] = new Estado(0);
			AFD[0].addTransition("g", 1);
			AFD[0].addTransition("r", 13);
			AFD[0].addTransition("y", 13);
			AFD[0].addTransition("b", 13);

			AFD[1] = new Estado(1);
			AFD[1].addTransition("g", 13);
			AFD[1].addTransition("r", 2);
			AFD[1].addTransition("y", 13);
			AFD[1].addTransition("b", 13);

			AFD[2] = new Estado(2);
			AFD[2].addTransition("g", 3);
			AFD[2].addTransition("r", 13);
			AFD[2].addTransition("y", 13);
			AFD[2].addTransition("b", 13);

			AFD[3] = new Estado(3);
			AFD[3].addTransition("g", 13);
			AFD[3].addTransition("r", 4);
			AFD[3].addTransition("y", 13);
			AFD[3].addTransition("b", 13);

			AFD[4] = new Estado(4);
			AFD[4].addTransition("g", 13);
			AFD[4].addTransition("r", 13);
			AFD[4].addTransition("y", 5);
			AFD[4].addTransition("b", 13);

			AFD[5] = new Estado(5);
			AFD[5].addTransition("g", 13);
			AFD[5].addTransition("r", 13);
			AFD[5].addTransition("y", 13);
			AFD[5].addTransition("b", 6);

			AFD[6] = new Estado(6);
			AFD[6].addTransition("g", 7);
			AFD[6].addTransition("r", 13);
			AFD[6].addTransition("y", 13);
			AFD[6].addTransition("b", 13);

			AFD[7] = new Estado(7);
			AFD[7].addTransition("g", 13);
			AFD[7].addTransition("r", 8);
			AFD[7].addTransition("y", 13);
			AFD[7].addTransition("b", 13);

			AFD[8] = new Estado(8);
			AFD[8].addTransition("g", 13);
			AFD[8].addTransition("r", 13);
			AFD[8].addTransition("y", 9);
			AFD[8].addTransition("b", 13);

			AFD[9] = new Estado(9);
			AFD[9].addTransition("g", 13);
			AFD[9].addTransition("r", 13);
			AFD[9].addTransition("y", 13);
			AFD[9].addTransition("b", 10);

			AFD[10] = new Estado(10);
			AFD[10].addTransition("g", 13);
			AFD[10].addTransition("r", 13);
			AFD[10].addTransition("y", 13);
			AFD[10].addTransition("b", 11);

			AFD[11] = new Estado(11);
			AFD[11].addTransition("g", 13);
			AFD[11].addTransition("r", 13);
			AFD[11].addTransition("y", 12);
			AFD[11].addTransition("b", 13);

			AFD[12] = new Estado(12);
			AFD[12].addTransition("g", 12);
			AFD[12].addTransition("r", 12);
			AFD[12].addTransition("y", 12);
			AFD[12].addTransition("b", 12);

			AFD[13] = new Estado(13);
			AFD[13].addTransition("g", 13);
			AFD[13].addTransition("r", 13);
			AFD[13].addTransition("y", 13);
			AFD[13].addTransition("b", 13);
			break;

		case 3:
			// Patron que debe serguir la iluminacion
			String[] patron3 = { "g", "r", "y", "b", "b", "y", "r", "g", "g" };
			patronIlumniar = patron3;

			// Automata Finito Determinista del nivel 3
			AFD = new Estado[20];
			AFD[0] = new Estado(0);
			AFD[0].addTransition("g", 1);
			AFD[0].addTransition("r", 19);
			AFD[0].addTransition("y", 19);
			AFD[0].addTransition("b", 19);

			AFD[1] = new Estado(1);
			AFD[1].addTransition("g", 19);
			AFD[1].addTransition("r", 2);
			AFD[1].addTransition("y", 19);
			AFD[1].addTransition("b", 19);

			AFD[2] = new Estado(2);
			AFD[2].addTransition("g", 19);
			AFD[2].addTransition("r", 19);
			AFD[2].addTransition("y", 3);
			AFD[2].addTransition("b", 19);

			AFD[3] = new Estado(3);
			AFD[3].addTransition("g", 4);
			AFD[3].addTransition("r", 19);
			AFD[3].addTransition("y", 19);
			AFD[3].addTransition("b", 19);

			AFD[4] = new Estado(4);
			AFD[4].addTransition("g", 19);
			AFD[4].addTransition("r", 5);
			AFD[4].addTransition("y", 19);
			AFD[4].addTransition("b", 19);

			AFD[5] = new Estado(5);
			AFD[5].addTransition("g", 19);
			AFD[5].addTransition("r", 19);
			AFD[5].addTransition("y", 6);
			AFD[5].addTransition("b", 19);

			AFD[6] = new Estado(6);
			AFD[6].addTransition("g", 19);
			AFD[6].addTransition("r", 19);
			AFD[6].addTransition("y", 19);
			AFD[6].addTransition("b", 7);

			AFD[7] = new Estado(7);
			AFD[7].addTransition("g", 19);
			AFD[7].addTransition("r", 19);
			AFD[7].addTransition("y", 19);
			AFD[7].addTransition("b", 8);

			AFD[8] = new Estado(8);
			AFD[8].addTransition("g", 19);
			AFD[8].addTransition("r", 19);
			AFD[8].addTransition("y", 9);
			AFD[8].addTransition("b", 19);

			AFD[9] = new Estado(9);
			AFD[9].addTransition("g", 10);
			AFD[9].addTransition("r", 19);
			AFD[9].addTransition("y", 19);
			AFD[9].addTransition("b", 19);

			AFD[10] = new Estado(10);
			AFD[10].addTransition("g", 19);
			AFD[10].addTransition("r", 11);
			AFD[10].addTransition("y", 19);
			AFD[10].addTransition("b", 19);

			AFD[11] = new Estado(11);
			AFD[11].addTransition("g", 19);
			AFD[11].addTransition("r", 19);
			AFD[11].addTransition("y", 12);
			AFD[11].addTransition("b", 19);

			AFD[12] = new Estado(12);
			AFD[12].addTransition("g", 19);
			AFD[12].addTransition("r", 19);
			AFD[12].addTransition("y", 19);
			AFD[12].addTransition("b", 13);

			AFD[13] = new Estado(13);
			AFD[13].addTransition("g", 19);
			AFD[13].addTransition("r", 19);
			AFD[13].addTransition("y", 19);
			AFD[13].addTransition("b", 14);

			AFD[14] = new Estado(14);
			AFD[14].addTransition("g", 19);
			AFD[14].addTransition("r", 19);
			AFD[14].addTransition("y", 15);
			AFD[14].addTransition("b", 19);

			AFD[15] = new Estado(15);
			AFD[15].addTransition("g", 19);
			AFD[15].addTransition("r", 16);
			AFD[15].addTransition("y", 19);
			AFD[15].addTransition("b", 19);

			AFD[16] = new Estado(16);
			AFD[16].addTransition("g", 17);
			AFD[16].addTransition("r", 19);
			AFD[16].addTransition("y", 19);
			AFD[16].addTransition("b", 19);

			AFD[17] = new Estado(17);
			AFD[17].addTransition("g", 18);
			AFD[17].addTransition("r", 19);
			AFD[17].addTransition("y", 19);
			AFD[17].addTransition("b", 19);

			AFD[18] = new Estado(18);
			AFD[18].addTransition("g", 18);
			AFD[18].addTransition("r", 18);
			AFD[18].addTransition("y", 18);
			AFD[18].addTransition("b", 18);

			AFD[19] = new Estado(19);
			AFD[19].addTransition("g", 19);
			AFD[19].addTransition("r", 19);
			AFD[19].addTransition("y", 19);
			AFD[19].addTransition("b", 19);
			break;

		case 4:
			// Patron que debe serguir la iluminacion
			String[] patron4 = { "g", "r", "y", "b", "b", "y", "r", "g", "g", "r", "g", "r" };
			patronIlumniar = patron4;

			// Automata Finito Determinista del nivel 4
			AFD = new Estado[25];
			AFD[0] = new Estado(0);
			AFD[0].addTransition("g", 1);
			AFD[0].addTransition("r", 24);
			AFD[0].addTransition("y", 24);
			AFD[0].addTransition("b", 24);

			AFD[1] = new Estado(1);
			AFD[1].addTransition("g", 24);
			AFD[1].addTransition("r", 2);
			AFD[1].addTransition("y", 24);
			AFD[1].addTransition("b", 24);

			AFD[2] = new Estado(2);
			AFD[2].addTransition("g", 24);
			AFD[2].addTransition("r", 24);
			AFD[2].addTransition("y", 3);
			AFD[2].addTransition("b", 24);

			AFD[3] = new Estado(3);
			AFD[3].addTransition("g", 24);
			AFD[3].addTransition("r", 24);
			AFD[3].addTransition("y", 24);
			AFD[3].addTransition("b", 4);

			AFD[4] = new Estado(4);
			AFD[4].addTransition("g", 5);
			AFD[4].addTransition("r", 24);
			AFD[4].addTransition("y", 24);
			AFD[4].addTransition("b", 24);

			AFD[5] = new Estado(5);
			AFD[5].addTransition("g", 24);
			AFD[5].addTransition("r", 6);
			AFD[5].addTransition("y", 24);
			AFD[5].addTransition("b", 24);

			AFD[6] = new Estado(6);
			AFD[6].addTransition("g", 24);
			AFD[6].addTransition("r", 24);
			AFD[6].addTransition("y", 7);
			AFD[6].addTransition("b", 24);

			AFD[7] = new Estado(7);
			AFD[7].addTransition("g", 24);
			AFD[7].addTransition("r", 24);
			AFD[7].addTransition("y", 24);
			AFD[7].addTransition("b", 8);

			AFD[8] = new Estado(8);
			AFD[8].addTransition("g", 24);
			AFD[8].addTransition("r", 24);
			AFD[8].addTransition("y", 24);
			AFD[8].addTransition("b", 9);

			AFD[9] = new Estado(9);
			AFD[9].addTransition("g", 24);
			AFD[9].addTransition("r", 24);
			AFD[9].addTransition("y", 10);
			AFD[9].addTransition("b", 24);

			AFD[10] = new Estado(10);
			AFD[10].addTransition("g", 24);
			AFD[10].addTransition("r", 11);
			AFD[10].addTransition("y", 24);
			AFD[10].addTransition("b", 24);

			AFD[11] = new Estado(11);
			AFD[11].addTransition("g", 12);
			AFD[11].addTransition("r", 24);
			AFD[11].addTransition("y", 24);
			AFD[11].addTransition("b", 24);

			AFD[12] = new Estado(12);
			AFD[12].addTransition("g", 13);
			AFD[12].addTransition("r", 24);
			AFD[12].addTransition("y", 24);
			AFD[12].addTransition("b", 24);

			AFD[13] = new Estado(13);
			AFD[13].addTransition("g", 24);
			AFD[13].addTransition("r", 14);
			AFD[13].addTransition("y", 24);
			AFD[13].addTransition("b", 24);

			AFD[14] = new Estado(14);
			AFD[14].addTransition("g", 24);
			AFD[14].addTransition("r", 24);
			AFD[14].addTransition("y", 15);
			AFD[14].addTransition("b", 24);

			AFD[15] = new Estado(15);
			AFD[15].addTransition("g", 24);
			AFD[15].addTransition("r", 24);
			AFD[15].addTransition("y", 24);
			AFD[15].addTransition("b", 16);

			AFD[16] = new Estado(16);
			AFD[16].addTransition("g", 24);
			AFD[16].addTransition("r", 24);
			AFD[16].addTransition("y", 24);
			AFD[16].addTransition("b", 17);

			AFD[17] = new Estado(17);
			AFD[17].addTransition("g", 24);
			AFD[17].addTransition("r", 24);
			AFD[17].addTransition("y", 18);
			AFD[17].addTransition("b", 24);

			AFD[18] = new Estado(18);
			AFD[18].addTransition("g", 24);
			AFD[18].addTransition("r", 19);
			AFD[18].addTransition("y", 24);
			AFD[18].addTransition("b", 24);

			AFD[19] = new Estado(19);
			AFD[19].addTransition("g", 20);
			AFD[19].addTransition("r", 24);
			AFD[19].addTransition("y", 24);
			AFD[19].addTransition("b", 24);

			AFD[20] = new Estado(20);
			AFD[20].addTransition("g", 21);
			AFD[20].addTransition("r", 24);
			AFD[20].addTransition("y", 24);
			AFD[20].addTransition("b", 24);

			AFD[21] = new Estado(21);
			AFD[21].addTransition("g", 24);
			AFD[21].addTransition("r", 22);
			AFD[21].addTransition("y", 24);
			AFD[21].addTransition("b", 24);

			AFD[22] = new Estado(22);
			AFD[22].addTransition("g", 23);
			AFD[22].addTransition("r", 24);
			AFD[22].addTransition("y", 24);
			AFD[22].addTransition("b", 24);

			AFD[23] = new Estado(23);
			AFD[23].addTransition("g", 23);
			AFD[23].addTransition("r", 23);
			AFD[23].addTransition("y", 23);
			AFD[23].addTransition("b", 23);

			AFD[24] = new Estado(24);
			AFD[24].addTransition("g", 24);
			AFD[24].addTransition("r", 24);
			AFD[24].addTransition("y", 24);
			AFD[24].addTransition("b", 24);
			break;

		case 5:
			// Patron que debe serguir la iluminacion
			String[] patron5 = { "g", "r", "y", "b", "b", "y", "r", "g", "g", "r", "g", "r", "y", "g", "y" };
			patronIlumniar = patron5;

			// Automata Finito Determinista del nivel 5
			AFD = new Estado[31];
			AFD[0] = new Estado(0);
			AFD[0].addTransition("g", 1);
			AFD[0].addTransition("r", 30);
			AFD[0].addTransition("y", 30);
			AFD[0].addTransition("b", 30);

			AFD[1] = new Estado(1);
			AFD[1].addTransition("g", 30);
			AFD[1].addTransition("r", 2);
			AFD[1].addTransition("y", 30);
			AFD[1].addTransition("b", 30);

			AFD[2] = new Estado(2);
			AFD[2].addTransition("g", 30);
			AFD[2].addTransition("r", 30);
			AFD[2].addTransition("y", 3);
			AFD[2].addTransition("b", 30);

			AFD[3] = new Estado(3);
			AFD[3].addTransition("g", 30);
			AFD[3].addTransition("r", 30);
			AFD[3].addTransition("y", 30);
			AFD[3].addTransition("b", 4);

			AFD[4] = new Estado(4);
			AFD[4].addTransition("g", 30);
			AFD[4].addTransition("r", 30);
			AFD[4].addTransition("y", 30);
			AFD[4].addTransition("b", 5);

			AFD[5] = new Estado(5);
			AFD[5].addTransition("g", 6);
			AFD[5].addTransition("r", 30);
			AFD[5].addTransition("y", 30);
			AFD[5].addTransition("b", 30);

			AFD[6] = new Estado(6);
			AFD[6].addTransition("g", 30);
			AFD[6].addTransition("r", 7);
			AFD[6].addTransition("y", 30);
			AFD[6].addTransition("b", 30);

			AFD[7] = new Estado(7);
			AFD[7].addTransition("g", 30);
			AFD[7].addTransition("r", 30);
			AFD[7].addTransition("y", 8);
			AFD[7].addTransition("b", 30);

			AFD[8] = new Estado(8);
			AFD[8].addTransition("g", 30);
			AFD[8].addTransition("r", 30);
			AFD[8].addTransition("y", 30);
			AFD[8].addTransition("b", 9);

			AFD[9] = new Estado(9);
			AFD[9].addTransition("g", 30);
			AFD[9].addTransition("r", 30);
			AFD[9].addTransition("y", 30);
			AFD[9].addTransition("b", 10);

			AFD[10] = new Estado(10);
			AFD[10].addTransition("g", 30);
			AFD[10].addTransition("r", 30);
			AFD[10].addTransition("y", 11);
			AFD[10].addTransition("b", 30);

			AFD[11] = new Estado(11);
			AFD[11].addTransition("g", 30);
			AFD[11].addTransition("r", 12);
			AFD[11].addTransition("y", 30);
			AFD[11].addTransition("b", 30);

			AFD[12] = new Estado(12);
			AFD[12].addTransition("g", 13);
			AFD[12].addTransition("r", 30);
			AFD[12].addTransition("y", 3);
			AFD[12].addTransition("b", 30);

			AFD[13] = new Estado(13);
			AFD[13].addTransition("g", 14);
			AFD[13].addTransition("r", 30);
			AFD[13].addTransition("y", 30);
			AFD[13].addTransition("b", 30);

			AFD[14] = new Estado(14);
			AFD[14].addTransition("g", 30);
			AFD[14].addTransition("r", 15);
			AFD[14].addTransition("y", 30);
			AFD[14].addTransition("b", 30);

			AFD[15] = new Estado(15);
			AFD[15].addTransition("g", 16);
			AFD[15].addTransition("r", 30);
			AFD[15].addTransition("y", 30);
			AFD[15].addTransition("b", 30);

			AFD[16] = new Estado(16);
			AFD[16].addTransition("g", 30);
			AFD[16].addTransition("r", 17);
			AFD[16].addTransition("y", 30);
			AFD[16].addTransition("b", 30);

			AFD[17] = new Estado(17);
			AFD[17].addTransition("g", 30);
			AFD[17].addTransition("r", 30);
			AFD[17].addTransition("y", 18);
			AFD[17].addTransition("b", 30);

			AFD[18] = new Estado(18);
			AFD[18].addTransition("g", 30);
			AFD[18].addTransition("r", 30);
			AFD[18].addTransition("y", 30);
			AFD[18].addTransition("b", 19);

			AFD[19] = new Estado(19);
			AFD[19].addTransition("g", 30);
			AFD[19].addTransition("r", 30);
			AFD[19].addTransition("y", 30);
			AFD[19].addTransition("b", 20);

			AFD[20] = new Estado(20);
			AFD[20].addTransition("g", 30);
			AFD[20].addTransition("r", 30);
			AFD[20].addTransition("y", 21);
			AFD[20].addTransition("b", 30);

			AFD[21] = new Estado(21);
			AFD[21].addTransition("g", 30);
			AFD[21].addTransition("r", 22);
			AFD[21].addTransition("y", 30);
			AFD[21].addTransition("b", 30);

			AFD[22] = new Estado(22);
			AFD[22].addTransition("g", 23);
			AFD[22].addTransition("r", 30);
			AFD[22].addTransition("y", 30);
			AFD[22].addTransition("b", 30);

			AFD[23] = new Estado(23);
			AFD[23].addTransition("g", 24);
			AFD[23].addTransition("r", 30);
			AFD[23].addTransition("y", 30);
			AFD[23].addTransition("b", 30);

			AFD[24] = new Estado(24);
			AFD[24].addTransition("g", 30);
			AFD[24].addTransition("r", 25);
			AFD[24].addTransition("y", 30);
			AFD[24].addTransition("b", 30);

			AFD[25] = new Estado(25);
			AFD[25].addTransition("g", 26);
			AFD[25].addTransition("r", 30);
			AFD[25].addTransition("y", 30);
			AFD[25].addTransition("b", 30);

			AFD[26] = new Estado(26);
			AFD[26].addTransition("g", 30);
			AFD[26].addTransition("r", 27);
			AFD[26].addTransition("y", 30);
			AFD[26].addTransition("b", 30);

			AFD[27] = new Estado(27);
			AFD[27].addTransition("g", 30);
			AFD[27].addTransition("r", 30);
			AFD[27].addTransition("y", 28);
			AFD[27].addTransition("b", 30);

			AFD[28] = new Estado(28);
			AFD[28].addTransition("g", 29);
			AFD[28].addTransition("r", 30);
			AFD[28].addTransition("y", 30);
			AFD[28].addTransition("b", 30);

			AFD[29] = new Estado(29);
			AFD[29].addTransition("g", 29);
			AFD[29].addTransition("r", 29);
			AFD[29].addTransition("y", 29);
			AFD[29].addTransition("b", 29);

			AFD[30] = new Estado(30);
			AFD[30].addTransition("g", 30);
			AFD[30].addTransition("r", 30);
			AFD[30].addTransition("y", 30);
			AFD[30].addTransition("b", 30);
			break;
		}

		// Aqui enviamos la primera secuencia a iluminar
		for (int i = 0; i < nivel; i++) {
			secuencia_iluminar.add(patronIlumniar[indexPatron]);
			indexPatron++;
		}

	}

	/*
	 * siguienteEstado: Esta clase se encarga de recorrer el automata utilizando
	 * sus funciones de transiciones y de terminar el juego cuando se llegue al
	 * estado final (ganar) o terminarlo por entrar en estado de error (perder).
	 * Regresa un true si el estado es no final o no es de error.
	 */
	public boolean siguienteEstado(String simbolo) {
		// Recorremos la entrada del usuario para buscar su funcion de
		// transicion respecto al estado actual
		for (int i = 0; i < 4; i++) {
			// Cuando encuentre la transicion que le corresponda va a moverse al
			// actuado que la transicion determine
			if (simbolo.equals(AFD[estadoActual].getTransiciones().get(i).simbolo)) {
				estadoActual = AFD[estadoActual].getTransiciones().get(i).getValor();
			}
		}

		// Si el estado actual no es final(posicion antepenultima del arreglo)
		// ni es estado de error (ultima posicion del arreglo) entonces envia la
		// siguiente secuencia para iluminar
		if (estadoActual != AFD.length - 1 && estadoActual != AFD.length - 2) {
			if (indexPresionado == (secuencia_iluminar.size() - 1)) {
				for (int i = 0; i < nivel; i++) {
					secuencia_iluminar.add(patronIlumniar[indexPatron]);
					indexPatron++;
				}
				indexPresionado = 0;
				return true;
			}
		}
		indexPresionado++;

		// Estado de error, termina el juego
		if (estadoActual == AFD.length - 1) {
			indexPresionado = 0;
			indexPatron = 0;
			secuencia_iluminar.clear();
			setActivo(false);
			setEstadoError(true);
			return false;
		}

		// Estado final, termina juego
		if (estadoActual == AFD.length - 2) {
			indexPresionado = 0;
			indexPatron = 0;
			secuencia_iluminar.clear();
			setEstadoFinal(true);
			setActivo(false);
			return false;
		} else {
			return true;
		}
	}

	public int getnEstadoActual() {
		return indexPresionado;
	}

	public void setnEstadoActual(int estado) {
		this.indexPresionado = estado;
	}

	public ArrayList<String> getAFDPatrones() {
		return secuencia_iluminar;
	}

	public void setAFDPatrones(ArrayList<String> AFD_Patrones) {
		this.secuencia_iluminar = AFD_Patrones;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public boolean isEstadoError() {
		return estadoError;
	}

	public void setEstadoError(boolean estadoError) {
		this.estadoError = estadoError;
	}

}