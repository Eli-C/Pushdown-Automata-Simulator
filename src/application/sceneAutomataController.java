package application;



import com.sun.javafx.css.Rule;
import com.sun.net.httpserver.Authenticator.Success;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.util.Duration;


public class sceneAutomataController {

	@FXML
	private TabPane mainTab;

	@FXML 
	private Tab formalDefinitionTab;

	@FXML
	private Button btnEstadoInicial;


	@FXML
	private MenuBar topMenu;   

	@FXML
	private Menu menuOpenFile;

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
	private Label editDeleteRuleLabel;

	@FXML
	private Label projectName;


	@FXML
	private TextField inputEstadoInicial;

	@FXML
	private TextField inputConjuntoEstados;

	@FXML
	private ListView recentFilesList;

	@FXML 
	private Tab automataTab;

	@FXML
	private TextField inputString;

	@FXML
	private Label currentWord;

	@FXML
	private Label initStack;

	@FXML
	private AnchorPane rulesShow;

	@FXML
	private TextField inputEstaosAcept;

	@FXML
	private Button btnEstadosAcept;

	@FXML
	private AnchorPane inputCadenaEntrada;

	@FXML
	private Button btnEditRule;

	@FXML
	private Button btnDeleteRule;

	@FXML
	private ChoiceBox<String> inputEstadoFuturo;

	@FXML
	private Button btnAlfabetoEntrada;

	@FXML
	private Button btnSimboloIniPila;

	@FXML
	private ChoiceBox<String> inputRuleEdit;

	@FXML
	private TextField inputAfabetoPila;

	@FXML
	private AnchorPane pane;

	@FXML
	private TextField inputAlfabetoEntrada;

	@FXML
	private ChoiceBox<String> inputPilaFutura;


	Automata automata = new Automata();

	ArrayList<String> Q = new ArrayList<>();
	ToggleGroup toggleGroup = new ToggleGroup();
	FileManager fm = new FileManager();

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
		this.loadRecentFiles();
		this.editDeleteRuleLabel.setVisible(false);
		this.inputRuleEdit.setVisible(false);
		this.btnDeleteRule.setVisible(false);
		this.btnEditRule.setVisible(false);
		this.inputActualState.setTooltip(new Tooltip("Estado Actual"));
		this.inputCE.setTooltip(new Tooltip("Entrada"));
		this.inputPilaActual.setTooltip(new Tooltip("Pila Actual"));
		this.inputEstadoFuturo.setTooltip(new Tooltip("Estado Futuro"));
		this.inputPilaFutura.setTooltip(new Tooltip("Pila Futura"));
	}


	//Called when a file is double clicked from the main menu

	@FXML
	public void getFile(MouseEvent event) {
		if(event.getClickCount() == 2) {
			String fileSelected = this.recentFilesList.getSelectionModel().getSelectedItem().toString();
			Alert infoAlert = new Alert(AlertType.INFORMATION);
			infoAlert.setHeaderText("Loading your file");
			infoAlert.setContentText("Opening your saved file. Click on Ok to continue...");
			infoAlert.showAndWait();
			this.projectName.setText(fileSelected.toUpperCase());
			this.mainTab.getSelectionModel().selectNext();
			try {
				this.automata = this.fm.getAutomata(fileSelected);
			} catch (FileNotFoundException ex) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Oops! There was a problem");
				errorAlert.setContentText("Error while retrieving the file.");
				errorAlert.showAndWait();
			}
		}
	}


	//Called when openFile from menu is clicked

	@FXML
	public void loadFile() {
		RadioMenuItem selectedRadioButton = (RadioMenuItem) this.toggleGroup.getSelectedToggle();
		String filename = selectedRadioButton.getText();
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setHeaderText("Loading your file");
		infoAlert.setContentText("Opening your saved file. Click on Ok to continue...");
		infoAlert.showAndWait();
		try {
			this.automata = this.fm.getAutomata(filename);
			this.projectName.setText(filename.toUpperCase());
		} catch (FileNotFoundException ex) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Oops! There was a problem");
			errorAlert.setContentText("Error while retrieving the file.");
			errorAlert.showAndWait();
		}

	}

	@FXML
	public void saveFile() {
		TextInputDialog dialog = new TextInputDialog("myFile");
		dialog.setTitle("Filename");
		dialog.setHeaderText("To save your file we need a name.");
		dialog.setContentText("Please enter your fileName: ");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> {
			try {
				this.fm.saveAutomata(name, automata);
				RadioMenuItem r1 = new RadioMenuItem(name + ".json");
				r1.setToggleGroup(this.toggleGroup);
				this.menuOpenFile.getItems().add(r1);
			} catch (IOException ex) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Error while saving file");
				errorAlert.setContentText("FileName not valid.");
				errorAlert.showAndWait();		
			}
		});

	}

	@FXML 
	public void reRender() {
		this.loadRecentFiles();
	}



	@FXML
	public void showEditComponent() {
		this.editDeleteRuleLabel.setVisible(true);
		this.inputRuleEdit.setVisible(true);
		this.btnDeleteRule.setVisible(true);
		this.btnEditRule.setVisible(true);
	}


	@FXML
	public void addRule() {
		Rules rule = new Rules();
		rule.setActualState(this.inputActualState.getSelectionModel().getSelectedItem().toString());
		rule.setInput(this.inputCE.getSelectionModel().getSelectedItem().toString());
		rule.setPilaActual(this.inputPilaActual.getSelectionModel().getSelectedItem().toString());
		rule.setFutureState(this.inputEstadoFuturo.getSelectionModel().getSelectedItem().toString());
		rule.setPilaFutura(this.inputPilaFutura.getSelectionModel().getSelectedItem().toString());

		if(this.btnAddRule.getText().equals("Edit")) {
			int index = this.inputRuleEdit.getSelectionModel().getSelectedIndex();
			this.automata.editRule(index, rule);
			this.btnAddRule.setText("Add");
			this.btnAddRule.getStyleClass().set(2, "primary");
		} else {
			this.automata.setRules(rule);
			inputRuleEdit.getItems().add(rule.getFormatedRule());
		}
	}

	@FXML
	public void EditRule() {
		this.editDeleteRuleLabel.setVisible(false);
		this.inputRuleEdit.setVisible(false);
		this.btnDeleteRule.setVisible(false);
		this.btnEditRule.setVisible(false);
		this.btnAddRule.setText("Edit");
		this.btnAddRule.getStyleClass().set(2, "info");
	}

	@FXML
	public void DeleteRule() {
		
		int index = this.inputRuleEdit.getSelectionModel().getSelectedIndex();
		
		this.editDeleteRuleLabel.setVisible(false);
		this.inputRuleEdit.setVisible(false);
		this.btnDeleteRule.setVisible(false);
		this.btnEditRule.setVisible(false);
		this.automata.deteleRule(index);
		this.inputRuleEdit.getItems().remove(index);
	}


	@FXML 
	public void simulate() {

		if(this.btnStart.getText().equals("Start")) {
			this.btnAddRule.setDisable(true);
			this.inputActualState.setDisable(true);
			this.inputCE.setDisable(true);
			this.inputPilaActual.setDisable(true);
			this.inputEstadoFuturo.setDisable(true);
			this.inputPilaFutura.setDisable(true);
			this.topMenu.setDisable(true);
			this.formalDefinitionTab.setDisable(true);
			this.inputString.setDisable(true);
			this.btnStart.getStyleClass().set(1, "danger");
			this.btnStart.setText("Stop");

		} else {
			this.btnAddRule.setDisable(false);
			this.inputActualState.setDisable(false);
			this.inputCE.setDisable(false);
			this.inputPilaActual.setDisable(false);
			this.inputEstadoFuturo.setDisable(false);
			this.inputPilaFutura.setDisable(false);
			this.topMenu.setDisable(false);
			this.formalDefinitionTab.setDisable(false);
			this.inputString.setDisable(false);
			this.btnStart.getStyleClass().set(1, "success");
			this.btnStart.setText("Start");
		}                    
	}


	private void loadRecentFiles() {
		this.recentFilesList.getItems().clear();
		this.menuOpenFile.getItems().clear();
		try {
			Files.newDirectoryStream(Paths.get("./savedData"),path -> path.toString().endsWith(".json"))
			.forEach(filePath -> { 
				RadioMenuItem r1 = new RadioMenuItem(filePath.getFileName().toString());
				r1.setToggleGroup(this.toggleGroup);
				this.recentFilesList.getItems().add(filePath.getFileName());
				this.menuOpenFile.getItems().add(r1);
			});
		} catch (IOException ex) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("No files found");
			errorAlert.setContentText(ex.toString());
			errorAlert.showAndWait();	

		}
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
			
			successMessageAlert();
			inputConjuntoEstados.setText("");;
		}

		automata.setQ(Q_Scene);
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
			
			successMessageAlert();
			inputAlfabetoEntrada.setText("");
		}
		automata.setX(X_Scene);
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
			
			successMessageAlert();
			inputAfabetoPila.setText("");
		}
		automata.setP(P_Scene);
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
				q0Exists = true;
				successMessageAlert();
				inputEstadoInicial.setText(q0_Scene);
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
				Z0Exists = true;
				successMessageAlert();
				inputSimboloIniPila.setText(Z0_Scene);
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
			successMessageAlert();
			inputEstaosAcept.setText("");
		}
		automata.setF(F_Scene);
	}


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
