package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulate {
	private ArrayList<Rules> rules;
	private ArrayList<Integer> solution;
	
	public Simulate(Automata automata) {
            this.rules = automata.getRules();
            this.solution = new ArrayList<Integer>();
	}
	public boolean testWord(String input, String state, Stack<String> stack) {
		System.out.println("input = " + input + " state = " + state + " stack = " + stack.toString());
		if(input.isEmpty() && state == "Aceptar" || stack.isEmpty()) {
			System.out.println("Found solution");
			return true;
		}
		Stack<String> copyStack = (Stack<String>) stack.clone();
		String pilaActual = copyStack.pop();
		System.out.println("pilaActual = " + pilaActual);
		char word = Character.valueOf(input.charAt(0));

		System.out.println("word to be inserted = " + word);
		Stream<Rules> possibleRulesStream = rules.stream().filter(rule -> ((rule.getInput() == word) && (rule.getActualState().equals(state)) && (rule.getPilaActual().equals(pilaActual))));

		List<Rules> possibleRules = possibleRulesStream.collect(Collectors.toList());
		System.out.println("Possible rules are: " + possibleRules.toString());

		for(int i=0; i<possibleRules.size(); i++) {
			System.out.println("Current Stack is: " + stack.toString());
			if(possibleRules.get(i).getPilaFutura().equals("lambda")) {
				stack.pop();
				System.out.println("Stack popped is: " + stack.toString());
			} else {
				String addStack = possibleRules.get(i).getPilaFutura();
				for(int j=0; j<addStack.length()-1; j++) {
					char convert = addStack.charAt(i);
					stack.push(Character.toString(convert));
					System.out.println("Stack inserted is: " + stack.toString());
				}
			}
			
			if(testWord(input.substring(1), possibleRules.get(i).getFutureState(), stack)){
				//adding index of rules used 
				solution.add(rules.indexOf(possibleRules.get(i)));
				//Collections.reverse(solution);
				System.out.println(solution.toString());
				return true;
			}
		}
		return false;
	}
        
        public ArrayList<Integer> getSolution() {
            Collections.reverse(this.solution);
            return this.solution;
        }
}
