import java.util.StringTokenizer;
import java.util.Scanner;

public class MajMin{

    public static void main(String [] args) {
	String phrase="";
	Scanner sc = new Scanner (System.in);
	System.out.println("Entrez une phrase : ");
	phrase = sc.nextLine();
	StringTokenizer st = new StringTokenizer(phrase);
	int cpt=0;
	String res="";
	while(st.hasMoreTokens()){
	    if(cpt%2==0){
		res += st.nextToken().toUpperCase()+" ";
	    }
	    else
		res+=st.nextToken()+ " ";
	    cpt++;
	}
	System.out.println(res);
    }
}
