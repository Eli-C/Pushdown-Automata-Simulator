package application;

import java.util.ArrayList;

public class Automata {
	
	private ArrayList<String> Q = new ArrayList<>();
	private ArrayList<String> X = new ArrayList<>();
	private ArrayList<String> P = new ArrayList<>();
	private String q0;
	private String Z0;
	private ArrayList<String> F = new ArrayList<>();

	private ArrayList<Rules> rulesArray;

	
	public Automata()
	{
		
	}
	
	public Automata(ArrayList<String> Q, ArrayList<String> X, ArrayList<String> P, String q0, String Z0, ArrayList<String> F, ArrayList<Rules> rules)
	{
		this.Q = Q;
		this.X = X;
		this.P = P;
		this.q0 = q0; 
		this.Z0 = Z0;
		this.F = F;	
        this.rulesArray = rules;
	}
        
	public void setRules(Rules rule) {
		rulesArray.add(rule);
	}
	
	public ArrayList<Rules> getRules() {
		return rulesArray;
	}
	
	public Rules getRule(int i) {
		return rulesArray.get(i);
	}
        
  public Rules deteleRule(int i) {
    return rulesArray.remove(i);
  }
        
  public Rules editRule(int i, Rules modifiedRule) {
    return rulesArray.set(i, modifiedRule);
  }

	public ArrayList<String> getQ() 
	{
		return Q;
	}
	public void setQ(ArrayList<String> q) 
	{
		Q = q;
	}
	public ArrayList<String> getX() 
	{
		return X;
	}
	public void setX(ArrayList<String> x) 
	{
		X = x;
	}
	public ArrayList<String> getP() 
	{
		return P;
	}
	public void setP(ArrayList<String> p) 
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
	public ArrayList<String> getF() 
	{
		return F;
	}
	public void setF(ArrayList<String> f) 
	{
		F = f;
	}

}
