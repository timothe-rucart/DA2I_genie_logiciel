import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

public class InverseMots{

    public static String inverse(String s){
	String res="";
	StringTokenizer st = new StringTokenizer(s);
	Stack stack = new Stack();

	while(st.hasMoreElements()){
	    stack.push(st.nextToken());
	}

	while(!stack.empty()){
	    res += stack.pop()+" ";
	}
	
	return res;
    }
    
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	System.out.println("Entrez une phrase: ");
	String phrase = sc.nextLine();
	String res = inverse(phrase);
	
	System.out.println(res);
    }
}
