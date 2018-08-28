package application;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

public class Simulate {

	private String input;
	private String initialState;
	public Stack<String> stack;
	private String result;
	
	public Simulate() {
		this.stack.push("Z");
	}
	
	public String testWord(String input, String initialState) {
		this.input = input;
		this.initialState = initialState;
		Stack<String> stackcopy = stack;
		
		for (int i=0; i<input.length(); i++) {
			String read = String.valueOf(input.charAt(i));
			
		}
		
		return result;
	}
	
	public int findBestRule(char word, String state) {
		Automata automata = new Automata();
		ArrayList<Rules> rules = automata.getRules();
		Stream<Rules> possibleRules = rules.stream().filter(rule -> ((rule.getInput() == word) && (rule.getActualState() == state)));
		
		return 0;
	}
	
}
