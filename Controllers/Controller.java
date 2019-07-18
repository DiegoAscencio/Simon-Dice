package app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.AFD_Patrones;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Clase Controller: Esta clase es el intermediario entre la interfaz grafica y
 * la funcionalidad del algoritmo, aqui se lleva acabo la lectura de entradas
 * del usuario y en base a estas se realizan las transiciones de estados
 */

public class Controller implements Initializable {
	// Creamos un objeto de la clase AFD_Patrones que contiene el AFD que
	// determina el funcionamiento del juego y el patron que se debe iluminar
	private AFD_Patrones afd_patrones = new AFD_Patrones();

	@FXML
	// ChoiceBox para seleccionar nivel
	private ChoiceBox<String> level = new ChoiceBox<String>();
	ObservableList<String> levelList = FXCollections.observableArrayList();

	@FXML
	private AnchorPane gp;

	@FXML
	private Rectangle rVerde;

	@FXML
	private Rectangle rRojo;

	@FXML
	private Rectangle rAmarillo;

	@FXML
	private Rectangle rAzul;

	@FXML
	private Button startBtn;

	@FXML
	// Al presionar el boton de inicio se carga el AFD definido por el nivel
	// seleccionado, despues se anima el primer patron de colores
	private void handleButtonAction(ActionEvent e) {
		afd_patrones.cargarAFD(Integer.valueOf(level.getValue()));
		resaltarPatron(afd_patrones.getAFDPatrones());
	}

	@FXML
	// Se encarga de leer el choiceBox de los niveles
	private void loadLevel() {
		levelList.removeAll(levelList);
		levelList.addAll("1", "2", "3", "4", "5");
		level.getItems().addAll(levelList);
		level.getSelectionModel().selectFirst();
	}

	@FXML
	// Si el juego esta activo, este metodo lee los clicks sobre los rectangulos
	// de colores y realiza la transicion de estado en el AFD. Ademas despliega
	// una alerta en caso de que el juego termine (llegue al estado final o de
	// error)
	private void userInput(MouseEvent e) {
		if (afd_patrones.isActivo()) {
			if (e.getSource() == rVerde) {
				if (!afd_patrones.siguienteEstado("g")) {
					if (afd_patrones.isEstadoError()) {
						alertaPerdiste();
					} else if (afd_patrones.isEstadoFinal()) {
						alertaGanaste();
					}
				}
			}
			if (e.getSource() == rRojo) {
				if (!afd_patrones.siguienteEstado("r")) {
					if (afd_patrones.isEstadoError()) {
						alertaPerdiste();
					} else if (afd_patrones.isEstadoFinal()) {
						alertaGanaste();
					}
				}
			}
			if (e.getSource() == rAmarillo) {
				if (!afd_patrones.siguienteEstado("y")) {
					if (afd_patrones.isEstadoError()) {
						alertaPerdiste();
					} else if (afd_patrones.isEstadoFinal()) {
						alertaGanaste();
					}
				}
			}
			if (e.getSource() == rAzul) {
				if (!afd_patrones.siguienteEstado("b")) {
					if (afd_patrones.isEstadoError()) {
						alertaPerdiste();
					} else if (afd_patrones.isEstadoFinal()) {
						alertaGanaste();
					}
				}
			}
			if (afd_patrones.getnEstadoActual() == 0) {
				resaltarPatron(afd_patrones.getAFDPatrones());
			}
		}
	}

	// Este metodo recibe una lista de colores que debe iluminar, la itera y
	// aplica un Fade a cada rectangulo en base al color de la lista
	public void resaltarPatron(ArrayList<String> secuencia) {
		SequentialTransition s = new SequentialTransition();
		s.setCycleCount(1);
		s.setAutoReverse(false);
		for (int i = 0; i < secuencia.size(); i++) {
			switch (secuencia.get(i)) {
			case "g":
				FadeTransition fadeVerde = new FadeTransition(Duration.millis(300), rVerde);
				fadeVerde.setAutoReverse(true);
				fadeVerde.setFromValue(1.0);
				fadeVerde.setToValue(0.1);
				fadeVerde.setCycleCount(2);
				s.getChildren().add(fadeVerde);
				break;
			case "r":
				FadeTransition fadeRojo = new FadeTransition(Duration.millis(300), rRojo);
				fadeRojo.setAutoReverse(true);
				fadeRojo.setFromValue(1.0);
				fadeRojo.setToValue(0.1);
				fadeRojo.setCycleCount(2);
				s.getChildren().add(fadeRojo);
				break;
			case "y":
				FadeTransition fadeAmarillo = new FadeTransition(Duration.millis(300), rAmarillo);
				fadeAmarillo.setAutoReverse(true);
				fadeAmarillo.setFromValue(1.0);
				fadeAmarillo.setToValue(0.1);
				fadeAmarillo.setCycleCount(2);
				s.getChildren().add(fadeAmarillo);
				break;
			case "b":
				FadeTransition fadeAzul = new FadeTransition(Duration.millis(300), rAzul);
				fadeAzul.setAutoReverse(true);
				fadeAzul.setFromValue(1.0);
				fadeAzul.setToValue(0.1);
				fadeAzul.setCycleCount(2);
				s.getChildren().add(fadeAzul);
				break;
			}
		}
		s.play();
	}

	// Este metodo despliega el mensaje de juego perdido
	private void alertaPerdiste() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Simón  Dice");
		alert.setHeaderText("Perdiste");
		alert.setContentText("Pulsa el boton iniciar para comenzar otro juego");
		alert.show();
	}

	// Este metodo despliega el mensaje de juego Ganado
	private void alertaGanaste() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Simón  Dice");
		alert.setHeaderText("¡¡Ganaste!!");
		alert.setContentText("Pulsa el boton iniciar para comenzar otro juego");
		alert.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadLevel();
	}
}