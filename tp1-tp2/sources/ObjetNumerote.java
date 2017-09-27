public class ObjetNumerote{
    
    static int numero_var=1;
    final int NUMERO;

    public ObjetNumerote(){
	NUMERO=numero_var;
	numero_var++;      
    }

    public String toString(){
	return "Numero : "+NUMERO;
    }

    public static void main(String[]args){
	ObjetNumerote n1 = new ObjetNumerote();
	ObjetNumerote n2 = new ObjetNumerote();

	System.out.println(n1);
       	System.out.println(n2);
    }
}
