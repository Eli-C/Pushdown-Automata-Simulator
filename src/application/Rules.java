package application;

public class Rules {
	
	
	private AutomataState actualState;
	private char input; 
	private Pila pilaActual;
	private AutomataState futureState;
	private Pila pilaFutura;
	
	
	public Rules (AutomataState actualState, char input, Pila pilaActual, AutomataState futureState, Pila pilaFutura)
	{
		this.actualState = actualState;
		this.input = input;
		this.pilaActual = pilaActual;
		this.futureState = futureState;
		this.pilaFutura = pilaFutura;
	}
	
	public AutomataState getActualState() 
	{
		return actualState;
	}
	public void setActualState(AutomataState actualState) 
	{
		this.actualState = actualState;
	}
	public char getInput() 
	{
		return input;
	}
	public void setInput(char input) 
	{
		this.input = input;
	}
	public Pila getPilaActual() 
	{
		return pilaActual;
	}
	public void setPilaActual(Pila pilaActual) 
	{
		this.pilaActual = pilaActual;
	}
	public AutomataState getFutureState() 
	{
		return futureState;
	}
	public void setFutureState(AutomataState futureState) 
	{
		this.futureState = futureState;
	}
	public Pila getPilaFutura() 
	{
		return pilaFutura;
	}
	public void setPilaFutura(Pila pilaFutura) 
	{
		this.pilaFutura = pilaFutura;
	}

}
