import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class StockMots{

    public static void main(String[] args){

	String phrase="";
	Scanner sc = new Scanner (System.in);
	System.out.println("Entrez une phrase : ");
	phrase = sc.nextLine();
	StringTokenizer st = new StringTokenizer(phrase);
	ArrayList<String> list = new ArrayList<>();
	while(st.hasMoreTokens()){
	    list.add(st.nextElement().toString());
	}

	Collections.sort(list);
	for(String s : list){
	    System.out.println(s+" ");
	}
    }
}
