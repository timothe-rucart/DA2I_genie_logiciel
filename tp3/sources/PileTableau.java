public class PileTableau<E> implements Pile<E>{

    private E[] elements;    // les elements contenus dans la pile
    private int nbElem = 0 ; // le nombre delements dans la pile
    private String nom ;     // nom de la pile : information supplementaire propre a PileTableau

    public PileTableau (String nom){
	this.nom = nom;
	elements = (E[]) new Object[MAX_ELEMENTS];
    }
    
    public boolean vide(){
	return nbElem == 0;
    }

    public boolean pleine(){
	return nbElem == MAX_ELEMENTS;
    }
    
    public boolean peutEmpiler(E x){
	return !pleine();
    }
    
    public E sommet(){
	return elements[nbElem -1];
    }
    
    public E depile(){
	E var = elements[nbElem -1];
	elements[nbElem -1]=null;
	nbElem--;
	return var;
    }
    
    public void empile(E x){
	if(!pleine()){
	    elements[nbElem]=x;
	    nbElem++;
	}
	else{
	    System.out.println("la pile est pleine");
	}
    }
    
    public void vider(){
	for(int i=0 ; i<nbElem ; i++){
	    elements[i]=null;
	}
    }
    
    public int nbElements(){
	return nbElem;
    }

    
    public String getNom(){
	return this.nom;
    }
    
    
    public void deplacerUnElementVers(Pile<E> p) {
	
	E var = sommet();
	p.empile(var);
	System.out.println("Pile de depart : "+nom);
 	System.out.println("Pile de fin : "+p.getNom());
    }

    public String toString() {
	String var="";

	for(int i=0 ; i<nbElem ; i++){
	    var += (i == nbElem -1) ? elements[i] : elements[i]+"-";
	}
	return var;
    }
    public static void main(String args[]){
	PileTableau<Integer> p1 = new PileTableau<Integer>("p1");
	PileTableau<Integer> p2 = new PileTableau<Integer>("p2");
        p1.empile(1);
        p1.empile(2);
        p1.empile(3);
	p1.deplacerUnElementVers(p2);

	System.out.println("sommet :"+p1.sommet());
	
    }

}
