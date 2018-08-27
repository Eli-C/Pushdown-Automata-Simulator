package application;

import java.util.ArrayList;
import java.util.Stack;

public class Simulate {

	private String word;
	private String initialState;
	public Stack<String> stack;
	private String result;
	
	public Simulate() {
		this.stack.push("Z");
	}
	
	public String testWord(String input, String initialState) {
		this.word = input;
		this.initialState = initialState;
		Automata automata = new Automata();
		ArrayList<Rules> rules = automata.getRules();
		Stack<String> stackcopy = stack;
		
		for (int i=0; i<input.length(); i++) {
			String read = String.valueOf(input.charAt(i));
			
		}
		
		return result;
	}
	
}
