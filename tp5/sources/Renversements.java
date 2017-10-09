import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

public class Renversements {

    static String retourneLettres( String s){
	String res = "";
	Stack stack = new Stack();
	StringTokenizer st = new StringTokenizer(s.toUpperCase());
	while(st.hasMoreElements()){
	    String var = st.nextToken();
	    for(int i=0 ; i< var.length() ; i++){
		stack.push( var.charAt(i));
	    }
	}
	while(!stack.empty()){
	    res += stack.pop();
	}
	return res;
    }


    static boolean estPalindrome(String s){
	return s.toUpperCase().equals(retourneLettres(s));
    }

    
    public static void main(String [] args){

	Scanner sc = new Scanner(System.in);
	System.out.println("Entrez une phrase: ");
	String phrase = sc.nextLine();


	String res = retourneLettres(phrase);	

	if(estPalindrome(res))
	    System.out.println("est palindrome");
	else
    	    System.out.println("n'est pas palindrome");
    }
}
