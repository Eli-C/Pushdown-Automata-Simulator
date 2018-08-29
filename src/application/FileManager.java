package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class FileManager {
    
        private Gson jsonParser;
		
	public FileManager()
	{
                this.jsonParser = new GsonBuilder().setPrettyPrinting().create();
                this.createBaseDirectory();
	}
        
        public void saveAutomata(String fileName, Automata automata) throws IOException {
            Writer writer = new FileWriter("savedData/" + fileName + ".json");
            System.out.print("Trying to save the automata");
            this.jsonParser.toJson(automata,writer);   
            writer.close();
            System.out.print("Finished");
        }
        
        public Automata getAutomata(String fileName) throws FileNotFoundException {
            System.out.print("Trying to get back the automata");
            FileReader reader = new FileReader("savedData/" + fileName + ".json");
            Automata m = this.jsonParser.fromJson(reader, Automata.class);
            return m;
        }
        
        private void createBaseDirectory() {
            new File("savedData").mkdir();
        }
}
