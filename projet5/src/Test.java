import calculatrice.* ;
import calculatrice2.Calculatrice2;

public class Test {
    public static void main(String [] args) {
        if (args.length < 2) 
            System.err.println("Au moins deux nombres sur la ligne de commande !") ;
        else {

           /* double x = new Double(args[0]) ;
            String oper = new String(args[1]);
            double y = new Double(args[2]) ;                                  
            
            for (Operation o: Operation.values())
            	if(o.toString().equals(oper))
                System.out.println(x + " " + o + " " + y + " = "+o.eval(x,y)) ;
        */
        	
        	Calculatrice2 cal = new Calculatrice2();
        	System.out.println(cal.calculer("-1 1 5 6 * 40 - IF"));
        }
    }
}
