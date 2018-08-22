package application;

public class AutomataState {
	
	
	private String name;
	private int actualState;  /* 	visit = 0 if we are not in the actual state
									visit = 1 if we are in the actual state
							*/
	
	public AutomataState(String name, int actualState)
	{
		this.name = name;
		this.actualState = actualState;
	}
	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getActualState() 
	{
		return actualState;
	}
	public void setActualState(int actualState) 
	{
		this.actualState = actualState;
	}

}
