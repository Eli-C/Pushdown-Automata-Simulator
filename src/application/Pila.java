package application;

public class Pila {

	
	private char topePila;
	private char[] elements;
	
	
	public Pila(char topePila, char[] elements)
	{
		this.topePila = topePila;
		this.elements = elements;
	}


	public char getTopePila() 
	{
		return topePila;
	}


	public void setTopePila(char topePila) 
	{
		this.topePila = topePila;
	}


	public char[] getElements() 
	{
		return elements;
	}


	public void setElements(char[] elements) 
	{
		this.elements = elements;
	}
}
