package application;

public class Automata {
	
	private AutomataState[] Q;
	private char[] X;
	private char[] P;
	private AutomataState q0;
	private String Z0;
	private AutomataState[] F;
	
	public Automata(AutomataState[] Q, char[] X, char[] P, AutomataState q0, String Z0, AutomataState[] F)
	{
		this.Q = Q;
		this.X = X;
		this.P = P;
		this.q0 = q0;
		this.Z0 = Z0;
		this.F = F;		
	}
	
	public AutomataState[] getQ() 
	{
		return Q;
	}
	public void setQ(AutomataState[] q) 
	{
		Q = q;
	}
	public char[] getX() 
	{
		return X;
	}
	public void setX(char[] x) 
	{
		X = x;
	}
	public char[] getP() 
	{
		return P;
	}
	public void setP(char[] p) 
	{
		P = p;
	}
	public AutomataState getQ0() 
	{
		return q0;
	}
	public void setQ0(AutomataState q0) 
	{
		this.q0 = q0;
	}
	public String getZ0() 
	{
		return Z0;
	}
	public void setZ0(String z0) 
	{
		Z0 = z0;
	}
	public AutomataState[] getF() 
	{
		return F;
	}
	public void setF(AutomataState[] f) 
	{
		F = f;
	}

}
