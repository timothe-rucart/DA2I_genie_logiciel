package calculatrice;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculatrice {

	Stack<Double> resultat;
	HashMap<String, Operation> operations;
	
	public Calculatrice(){
		resultat = new Stack<>();
		operations = new HashMap<>();
		
		for(Operation o : Operation.values())
			operations.put(o.toString(), o);
	}
	
	public double calculer(String s){
		StringTokenizer str = new StringTokenizer(s);
		String var ="";
		
		while(str.hasMoreTokens()){
			var = str.nextToken();
			if(operations.containsKey(var)){
				double x = resultat.pop();
				double y = resultat.pop();
				resultat.push(operations.get(var).eval(x, y));
			}
			else
				resultat.push(Double.parseDouble(var));
		}
		return resultat.pop();	
	}
}
