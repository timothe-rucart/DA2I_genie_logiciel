import java.util.*;
public class Filtre{

    ArrayList<Integer> list = new ArrayList<>();
    
    public Filtre(int i){
	list.add(i);
    }

    public void filtrer(int x){
	boolean bool = true;
	int i=0;
	while(i<list.size() && bool){
	    if(x % list.get(i) == 0){
		bool = false;
	    }
	    i++;
	}
	if(bool)
	    list.add(x);
    }

    public String toString(){
	String res = "";
	Iterator<Integer> iter = list.iterator();
	while(iter.hasNext()){
	    res += iter.next()+" ";
	}
	return res;
    }    
}
