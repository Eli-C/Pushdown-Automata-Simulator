package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulate {
	private ArrayList<Rules> rules;
	
	public Simulate(Automata automata) {
            this.rules = automata.getRules();
	}
	public boolean testWord(String input, String state, Stack<String> stack) {
		
		if(input.isEmpty() && state == "Aceptar" || stack.isEmpty()) {
			return true;
		}
		String pilaActual = stack.pop();
		char word = Character.valueOf(input.charAt(0));
		Stream<Rules> possibleRulesStream = rules.stream().filter(rule -> ((rule.getInput() == word) && (rule.getActualState() == state) && (rule.getPilaActual() == pilaActual)));
		List<Rules> possibleRules = possibleRulesStream.collect(Collectors.toList());

		for(int i=0; i<possibleRules.size(); i++) {
			if(possibleRules.get(i).getPilaFutura() == "lambda") {
				stack.pop();
			} else {
				String addStack = possibleRules.get(i).getPilaFutura();
				String stackIt = "";
				for(int j=0; j<addStack.length()-1; j++) {
					
				}
				stack.push(addStack);
			}
			
			if(testWord(input.substring(1), possibleRules.get(i).getFutureState(), stack)){
				return true;
			}
		}
		return false;
	}
}
