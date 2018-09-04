package application;

import java.util.ArrayList;
import java.util.Stack;
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
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
                ArrayList<String> Q = new ArrayList<>();
                Q.add("Leer");
                Q.add("Comp");
                ArrayList<String> X = new ArrayList<String>();
                X.add("a");
                X.add("b");
                ArrayList<String> P = new ArrayList<>();
                P.add("a");
                P.add("b");
                String Q0 = "Leer";
                String Z0 = "Z";
                ArrayList<String> F = new ArrayList<>();
                ArrayList<Rules> rules = new ArrayList<Rules>();
                rules.add(new Rules("Leer",'a',"Z","Leer","AZ"));
                rules.add(new Rules("Leer",'a',"A","Leer","AA"));
                rules.add(new Rules("Leer",'b',"A","Comp","lambda"));
                rules.add(new Rules("Comp",'b',"A","Comp","lambda"));
                rules.add(new Rules("Comp",'l',"Z","Aceptar","lambda"));
                Stack<String> stack = new Stack<String>();
                stack.push("Z");
                Automata m = new Automata(Q,X,P,Q0,Z0,F,rules);
                Simulate s = new Simulate(m);
                boolean result = s.testWord("aabbl", m.getQ0(), stack);
                System.out.println("The result for word test is " + result);
                System.out.println("Solucion final:" + s.getSolution().toString());
                launch(args);
	}
}
