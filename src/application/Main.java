package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("sceneAutomata.fxml"));
			
			primaryStage.setTitle("Automata Simulator");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
			/*BorderPane root = new BorderPane();
			
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
                launch(args);
	}
}
