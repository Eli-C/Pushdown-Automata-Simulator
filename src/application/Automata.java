package application;

public class Automata {
	
	private String[] Q;
	private char[] X;
	private char[] P;
	private String q0;
	private String Z0;
	private String[] F;
	
	public Automata(String[] Q, char[] X, char[] P, String q0, String Z0, String[] F)
	{
		this.Q = Q;
		this.X = X;
		this.P = P;
		this.q0 = q0;
		this.Z0 = Z0;
		this.F = F;		
	}
	
	public String[] getQ() 
	{
		return Q;
	}
	public void setQ(String[] q) 
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
	public String getQ0() 
	{
		return q0;
	}
	public void setQ0(String q0) 
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
	public String[] getF() 
	{
		return F;
	}
	public void setF(String[] f) 
	{
		F = f;
	}

}
