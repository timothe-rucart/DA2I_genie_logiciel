import java.util.ArrayList;
public  class InstanceMemo{


    public static int numero_var=0;
    public final int NUMERO;
    public static ArrayList<Integer> list = new ArrayList<>();

    InstanceMemo(){
        NUMERO=numero_var;
	list.add(NUMERO);
	numero_var++;
    }

    public static int nombreInstances(){
	return numero_var;
    }

    public static void afficherInstances(){

	if(list.size()<10){
	    for(int i=0 ; i<list.size() ; i++){
		System.out.println(list.get(i)+1);
	    }
	}
	else{
	    int n = list.size()-10;
	    for(int i=n ; i<list.size() ; i++){
		System.out.println(list.get(i)+1);
	    }
	}
    }
    public static void main(String[] args){

	int i ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo") ;
        for (i=1; i<=4; i++) new InstanceMemo() ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo : ") ;
        InstanceMemo.afficherInstances() ;
        for (i=1; i<=10; i++) new InstanceMemo() ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo : ") ;
        InstanceMemo.afficherInstances() ;
    }
}
