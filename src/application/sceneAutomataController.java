package application;

import java.util.ArrayList;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//import java.awt.Button;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class sceneAutomataController {
	
	    @FXML
	    private Button btnEstadoInicial;

	    @FXML
	    private ChoiceBox<?> inputActualState;

	    @FXML
	    private ChoiceBox<?> inputPilaActual;

	    @FXML
	    private Button btnAddRule;

	    @FXML
	    private TextField inputSimboloIniPila;

	    @FXML
	    private Button btnConjEstados;

	    @FXML
	    private Button inputAlfabetoPila;

	    @FXML
	    private Button btnStart;

	    @FXML
	    private ChoiceBox<?> inputCE;

	    @FXML
	    private TextField inputEstadoInicial;

	    @FXML
	    private TextField inputConjuntoEstados;

	    @FXML
	    private AnchorPane rulesShow;

	    @FXML
	    private TextField inputEstaosAcept;

	    @FXML
	    private Button btnEstadosAcept;

	    @FXML
	    private AnchorPane inputCadenaEntrada;

	    @FXML
	    private Button bntDeleteRule;

	    @FXML
	    private ChoiceBox<?> inputEstadoFuturo;

	    @FXML
	    private Button btnAlfabetoEntrada;

	    @FXML
	    private Button btnSimboloIniPila;

	    @FXML
	    private ChoiceBox<?> inputRuleEdit;

	    @FXML
	    private TextField inputAfabetoPila;

	    @FXML
	    private AnchorPane pane;

	    @FXML
	    private TextField inputAlfabetoEntrada;

	    @FXML
	    private ChoiceBox<?> inputPilaFutura;
	    
	    
	    Automata automata = new Automata();
    	ArrayList<String> Q = new ArrayList<>();
	    
	    public sceneAutomataController()
	    {
	    	
	    }
	    
	    
	    @FXML
	    private void initialize()
	    {

	    }

	    /* 
	    @FXML
	    public void read_Q()
	    {
	    	Alert errorAlert = new Alert(AlertType.ERROR);
	    		    	
	    	System.out.println(inputConjuntoEstados.getText());
	    	if (inputConjuntoEstados.getText() != "") 
	    	{
	    		Q.add(inputConjuntoEstados.getText());
			}
	    	else 
	    	{
	    		errorAlert.setHeaderText("Input not valid");
		    	errorAlert.setContentText("This text area must contains the appropiate words.");
		    	errorAlert.showAndWait();		
			}
	    	//automata.setQ(Q);
	    }
	    
	    */


}
