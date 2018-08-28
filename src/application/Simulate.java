package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulate {
	private boolean result;
	private ArrayList<Rules> rules;
	
	public Simulate() {
		Automata automata = new Automata();
		ArrayList<Rules> rules = automata.getRules();
		this.rules = rules;
	}
	
	public boolean testWord(String input, String state, Stack<Character> stack) {
		
		if(input.isEmpty() && state == "Aceptar" || stack.isEmpty()) {
			return true;
		}
		char pilaActual = stack.pop();
		char word = Character.valueOf(input.charAt(0));
		Stream<Rules> possibleRulesStream = rules.stream().filter(rule -> ((rule.getInput() == word) && (rule.getActualState() == state) && (rule.getPilaActual() == pilaActual)));
		List<Rules> possibleRules = possibleRulesStream.collect(Collectors.toList());

		for(int i=0; i<possibleRules.size(); i++) {
			if(possibleRules.get(i).getPilaFutura() == 'l') {
				stack.pop();
			} else {
				char addStack = possibleRules.get(i).getPilaFutura();
				stack.push(addStack);
			}
			
			if(testWord(input.substring(1), possibleRules.get(i).getFutureState(), stack)){
				return true;
			}
		}
		return false;
	}
}
