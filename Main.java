package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * i) Programar clase principal: Esta clase se encarga de lanzar la
 * aplicacion, crea un stage (contenedor principal) y un scene (contenedor de
 * nodos) que se define en un archivo FXML.
 */

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws IOException {
		/*
		 * ii) Programar pane, node y scene: Se crea un Pane en forma de
		 * AnchorPane y carga el scene con el tema de los nodos.
		 * iii) Se carga
		 * el FXML en el anchor pane mediante un FXMLoader
		 */
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Fxml/Grafico.fxml"));
		Scene scene = new Scene(root, 700, 650);
		scene.getStylesheets().add("app/Style/Theme.css");
		stage.setTitle("Simon Dice");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}




