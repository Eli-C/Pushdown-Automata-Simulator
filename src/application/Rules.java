package application;

public class Rules {
	
	
	private String actualState;
	private char input; 
	private String pilaActual;
	private String futureState;
	private String pilaFutura;
	public Rules (String actualState, char input, String pilaActual, String futureState, String pilaFutura)
	{
		this.actualState = actualState;
		this.input = input;
		this.pilaActual = pilaActual;
		this.futureState = futureState;
		this.pilaFutura = pilaFutura;
	}
        
        public String getFormatedRule() {
            return "< " + this.actualState + ", " + this.input + ", " + this.pilaActual + ", " + this.futureState + ", " + this.pilaFutura + " >";
        }
	
	public String getActualState() 
	{
		return actualState;
	}
	public void setActualState(String actualState) 
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
	public String getPilaActual() 
	{
		return pilaActual;
	}
	public void setPilaActual(String pilaActual) 
	{
		this.pilaActual = pilaActual;
	}
	public String getFutureState() 
	{
		return futureState;
	}
	public void setFutureState(String futureState) 
	{
		this.futureState = futureState;
	}
	public String getPilaFutura() 
	{
		return pilaFutura;
	}
	public void setPilaFutura(String pilaFutura) 
	{
		this.pilaFutura = pilaFutura;
	}
}
