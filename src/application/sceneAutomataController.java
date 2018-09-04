package application;


import java.io.File;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
            private Label editDeleteRuleLabel;

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
            
            @FXML
            public void getFile(MouseEvent event) {
                if(event.getClickCount() == 2) {
                    String fileSelected = this.recentFilesList.getSelectionModel().getSelectedItem().toString();
                    Alert infoAlert = new Alert(AlertType.INFORMATION);
                    infoAlert.setHeaderText("Loading your file");
                    infoAlert.setContentText("Opening your saved file. Click on Ok to continue...");
                    infoAlert.showAndWait();	
                    this.mainTab.getSelectionModel().selectNext();
                }
                
            }
            
            @FXML
            public void saveFile() {
                FileManager fm = new FileManager();
                TextInputDialog dialog = new TextInputDialog("myFile");
                dialog.setTitle("Filename");
                dialog.setHeaderText("To save your file we need a name.");
                dialog.setContentText("Please enter your fileName: ");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(name -> {
                    try {
                        fm.saveAutomata(name, automata);
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
	    public void read_Q()
	    {
	    	Alert errorAlert = new Alert(AlertType.ERROR);
	    		    	
	    	System.out.println(inputConjuntoEstados.getText());
	    	if (inputConjuntoEstados.getText().isEmpty()) 
	    	{
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("This text area must contains the appropiate words.");
                    errorAlert.showAndWait();		
                }
	    	else 
	    	{
                    Q.add(inputConjuntoEstados.getText());
            	}
	    	//automata.setQ(Q);
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
                }
            }
            
            @FXML
            public void EditRule() {
                int index = this.inputRuleEdit.getSelectionModel().getSelectedIndex();
                this.inputRuleEdit.getSelectionModel().select(index);
                this.editDeleteRuleLabel.setVisible(false);
                this.inputRuleEdit.setVisible(false);
                this.btnDeleteRule.setVisible(false);
                this.btnEditRule.setVisible(false);
                this.btnAddRule.setText("Edit");
                this.btnAddRule.getStyleClass().set(2, "info");
            }
            
            @FXML
            public void DeleteRule() {
                this.editDeleteRuleLabel.setVisible(false);
                this.inputRuleEdit.setVisible(false);
                this.btnDeleteRule.setVisible(false);
                this.btnEditRule.setVisible(false);
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
                
                
               
//                PathElement[] path2 = {
//                  new MoveTo(this.currentWord.getLayoutX() + 20,this.currentWord.getLayoutY()),
//                  new ArcTo(100,100,0,this.currentWord.getLayoutX(),this.currentWord.getLayoutY(),false,false),
//                  new LineTo(this.initStack.getLayoutX(),this.initStack.getLayoutY())
//                };
//                Path path = new Path();
//                path.getElements().add(new MoveTo(10,10));
//                path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
//                path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//                path.getElements().add(new MoveTo(40,300));
//                path.getElements().add(new CubicCurveTo(380, 0, 380, 380, 200, 120));
//                path.getElements().add(new CubicCurveTo(0, 120, 0, 380, 380, 240));
//                PathTransition pathTransition = new PathTransition();
//                pathTransition.setDuration(Duration.millis(9000));
//                pathTransition.setPath(path);
//                pathTransition.setNode(this.currentWord);
//                pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//                pathTransition.setCycleCount(Timeline.INDEFINITE);
//                pathTransition.setAutoReverse(true);
//                pathTransition.play();
                    
            }
            
            
            private void loadRecentFiles() {
                this.recentFilesList.getItems().clear();
                try {
                    Files.newDirectoryStream(Paths.get("./savedData"),path -> path.toString().endsWith(".json"))
                            .forEach(filePath -> this.recentFilesList.getItems().add(filePath.getFileName()));
                } catch (IOException ex) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("No files found");
                    errorAlert.setContentText(ex.toString());
                    errorAlert.showAndWait();	
                    
                }
            }
	    
	    


}
