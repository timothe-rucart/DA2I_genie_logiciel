import java.util.HashMap;
import java.util.Set;

public class Anagramme{

    public static HashMap<Character, Integer> compteLettreMap(String s1){
	HashMap<Character, Integer> map = new HashMap<>();
	int cpt=0;

	while(cpt<s1.length()){
	    char c = s1.charAt(cpt);
	    //si la lettre n'existe pas dans la map
	    if(!map.containsKey(c)){
		    map.put(c,1);
	    }
	    else{
		int n = map.get(c)+1;
		map.put(c,n);
	    }
	    cpt++;
	}
	return map;
    }

    public static boolean compare(HashMap<Character, Integer> hm1, HashMap<Character, Integer> hm2){
	System.out.println(hm1.size());
	if(hm1.size() == hm2.size()){
	    for(char c : hm1.keySet()){
		if(!hm2.containsKey(c) && !hm2.containsValue(hm2.get(c))){
		    return false;
		}
	    }
	}else
	    return false;
	return true;
    }
    public static void main(String args[]){
	HashMap<Character, Integer> h1 = compteLettreMap("chien");
	HashMap<Character, Integer> h2 = compteLettreMap("chine");

	System.out.println(compare(h1,h2));
    }
}
