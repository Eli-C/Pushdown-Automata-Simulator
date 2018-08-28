package application;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	
	private String fileName;
        private Automata currentAutomata;
        private Gson jsonParser;
	
	
	public FileManager(String fileName, Automata current)
	{
		this.fileName = fileName;
                this.currentAutomata = current;
                jsonParser = new Gson();
	}
        
        public void saveAutomata() {
            try {
              this.jsonParser.toJson(this.currentAutomata,new FileWriter("../data/" + this.fileName + ".json"));   
            } catch(IOException e) {
                System.err.println("Error" + e.getMessage());
            }
        }
        
        public Automata getAutomata() {
            try {
               Automata m = this.jsonParser.fromJson(new FileReader("../data/" + this.fileName + ".json"), Automata.class);
               return m;
            } catch(IOException e) {
                System.err.println("Error" + e.getMessage());
                return null;
            }
            
        }
	
	public String getFileName() 
	{
		return fileName;
	}

	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public Automata getCurrentAutomata() 
	{
            return currentAutomata;
	}

	public void setCurrentAutomata(Automata current) 
	{
		this.currentAutomata = current;
	}

}
