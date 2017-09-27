public class Eratosphene{

    public int[] tab;
    public int nombreTours = 0;
    
    public Eratosphene(int n){
	remplir_tableau(n);
    }


    public void remplir_tableau(int n){
	tab = new int[n-1];
	
	for(int i=2 ; i<=n ; i++){
	    tab[i-2]=i;
	}
    }

    public void afficherTableau(int[] tab){
	for(int i=0 ; i<tab.length ; i++){
	    System.out.println(tab[i]);
	}
    }

    public int[] supprimerNombre(){
	int[] tableau = tab;
	
	while(nombreTours<tab.length){
	    if(tab[nombreTours] != 0){
		for(int i=nombreTours ; i<tab.length-1 ; i++){
		    if(tab[i+1]!=0 && tab[i+1] % tab[nombreTours]== 0)
			tableau[i+1]=0;
		}
	    }
  	    nombreTours++;
	}
	return tableau;
    }
    
    public static void main(String[]args){

	/**
	Eratosphene e = new Eratosphene(20);
	e.supprimerNombre();
	e.afficherTableau();
	**/
	
	Generateur g = new Generateur(10000);
	g.travailler();
	System.out.println(g.toString());
    }
}
