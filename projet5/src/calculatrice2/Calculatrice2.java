package calculatrice2;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

import calculatrice.Operation;

public class Calculatrice2 {


	Stack<Double> resultat;
	HashMap<String, Operation2> operations;
	
	public Calculatrice2(){
		resultat = new Stack<>();
		operations = new HashMap<>();
		
		for(Operation2 o : Operation2.values())
			operations.put(o.toString(), o);
	}
	
	public double calculer(String s){
		StringTokenizer str = new StringTokenizer(s);
		String var ="";
		
		while(str.hasMoreTokens()){
			var = str.nextToken();
			
			if(operations.containsKey(var)){
				int cpt = operations.get(var).arite;
				Double [] tab = new Double[cpt];
				
				for(int i=0 ; i<cpt ; i++){
					tab[i]=resultat.pop();
				}
				resultat.push(operations.get(var).eval(tab));
			}
			else
				resultat.push(Double.parseDouble(var));
		}
		return resultat.pop();	
	}
	
}