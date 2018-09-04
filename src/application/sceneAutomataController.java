package application;

import java.util.ArrayList;

import com.sun.javafx.css.Rule;
import com.sun.net.httpserver.Authenticator.Success;

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
	    private ChoiceBox<String> inputActualState;

	    @FXML
	    private ChoiceBox<String> inputPilaActual;

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
	    private ChoiceBox<String> inputCE;

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
	    private ChoiceBox<String> inputEstadoFuturo;

	    @FXML
	    private Button btnAlfabetoEntrada;

	    @FXML
	    private Button btnSimboloIniPila;

	    @FXML
	    private ChoiceBox<Rules> inputRuleEdit;

	    @FXML
	    private TextField inputAfabetoPila;

	    @FXML
	    private AnchorPane pane;

	    @FXML
	    private TextField inputAlfabetoEntrada;

	    @FXML
	    private ChoiceBox<String> inputPilaFutura;
	    
	    
	    Automata automata = new Automata();
	    
    	ArrayList<String> Q_Scene = new ArrayList<>();
    	ArrayList<String> X_Scene = new ArrayList<>();
    	ArrayList<String> P_Scene = new ArrayList<>();
    	String q0_Scene; 
    	String Z0_Scene;
    	ArrayList<String> F_Scene = new ArrayList<>();
	    
    	boolean q0Exists = false;
    	boolean Z0Exists = false;
    	
	    public sceneAutomataController()
	    {
	    	
	    }
	    
	    
	    @FXML
	    private void initialize()
	    {

	    }

	     
	    @FXML
	    public void read_Q()
	    {
	    	if (inputConjuntoEstados.getText().isEmpty()) 
	    	{
	    		ErrorAlertMessage();
            }
	    	else 
	    	{
	    		Q_Scene.add(inputConjuntoEstados.getText());
	    		inputActualState.getItems().add(inputConjuntoEstados.getText());
	    		inputEstadoFuturo.getItems().add(inputConjuntoEstados.getText());
            }
	    	
	    	automata.setQ(Q_Scene);
	    	
	    	successMessageAlert();
	    }
	    
	    
	    @FXML
	    public void read_X()
	    {
	    	if (inputAlfabetoEntrada.getText().isEmpty()) 
	    	{
	    		ErrorAlertMessage();
            }
	    	else 
	    	{
                X_Scene.add(inputAlfabetoEntrada.getText());
                inputCE.getItems().add(inputAlfabetoEntrada.getText());
            }
	    	automata.setX(X_Scene);
	    	successMessageAlert();
	    }
	    
	    
	    @FXML
	    public void read_P()
	    {
	    	if (inputAfabetoPila.getText().isEmpty()) 
	    	{
	    		ErrorAlertMessage();
            }
	    	else 
	    	{
	    		P_Scene.add(inputAfabetoPila.getText());
	    		inputPilaActual.getItems().add(inputAfabetoPila.getText());
	    		inputPilaFutura.getItems().add(inputAfabetoPila.getText());
            }
	    	automata.setP(P_Scene);
	    	successMessageAlert();
	    }
	    
	    
	    @FXML
	    public void read_q0()
	    {
	    	if (inputEstadoInicial.getText().isEmpty()) 
	    	{
	    		ErrorAlertMessage();
	    	}
	    	else 
	    	{
	    		if(q0Exists == false)
	    		{
	    			q0_Scene = inputEstadoInicial.getText();
	    			automata.setQ0(q0_Scene);
	    			successMessageAlert();
	    			q0Exists = true;
	    		}
	    		else 
	    		{
	    			Alert errorAlert = new Alert(AlertType.ERROR);
	    	    	
	    	    	errorAlert.setHeaderText("Input not valid");
	                errorAlert.setContentText("Alredy exists an initial state. There should be only one initial state.");
	                errorAlert.showAndWait();
	                
	                inputEstadoInicial.setText(q0_Scene);
	                inputEstadoInicial.setDisable(true);
	                btnEstadoInicial.setDisable(true);
				}
	    	}
	    }
	    
	    
	    @FXML
	    public void read_Z0()
	    {
	    	if (inputSimboloIniPila.getText().isEmpty()) 
	    	{
	    		ErrorAlertMessage();
	    	}
	    	else 
	    	{
	    		if(Z0Exists == false)
	    		{
	    			Z0_Scene = inputSimboloIniPila.getText();
	    			automata.setZ0(Z0_Scene);
	    			successMessageAlert();
	    			Z0Exists = true;
	    		}
	    		else 
	    		{
	    			Alert errorAlert = new Alert(AlertType.ERROR);
	    	    	
	    	    	errorAlert.setHeaderText("Input not valid");
	                errorAlert.setContentText("Alredy exists an initial simbol for the stack. There should be only one initial symbol.");
	                errorAlert.showAndWait();	
	                
	                inputSimboloIniPila.setText(Z0_Scene);
	                inputSimboloIniPila.setDisable(true);
	                btnSimboloIniPila.setDisable(true);
				}
	    	}
	    }
	    
	    
	    @FXML
	    public void read_F()
	    {
	    	if (inputEstaosAcept.getText().isEmpty()) 
	    	{
	    		ErrorAlertMessage();
            }
	    	else 
	    	{
                    F_Scene.add(inputEstaosAcept.getText());
	    	}
	    	automata.setF(F_Scene);
	    	successMessageAlert();
	    }
	    
	    
	    
	    @FXML
	    public void populateRulesToEdit()
	    {
	    	for (int i = 0; i < automata.getRules().size(); i++) 
	    	{
				inputRuleEdit.getItems().add(automata.getRule(i));
			}
	    }
	    
	    
	    
	    @FXML
	    public void selectActualState()
	    {
	    	
	    }
	    
	    
	    @FXML
	    public void selectCE()
	    {}
	    
	    @FXML
	    public void selectPilaActual()
	    {}
	    
	    @FXML
	    public void selectFutureState()
	    {}
	    
	    @FXML
	    public void selectPilaFutura()
	    {}
	    
	    
	    public void ErrorAlertMessage()
	    {
	    	Alert errorAlert = new Alert(AlertType.ERROR);
	    	
	    	errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("This text area must contains the appropiate words.");
            errorAlert.showAndWait();		
	    }
	    
	    public void successMessageAlert()
	    {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("SUCCESS!");
	    	alert.setHeaderText("Variable saved");
	    	alert.showAndWait();
	    }

}
