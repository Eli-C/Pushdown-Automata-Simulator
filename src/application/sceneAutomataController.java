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


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class sceneAutomataController {
	
            @FXML
            private TabPane mainTab;
    
            @FXML 
            private Tab formalDefinitionTab;
            
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
            private ListView recentFilesList;

            @FXML 
            private Tab automataTab;
            
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
                this.loadRecentFiles();
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
            public void reRenderFiles() {
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
	    
	    


}
