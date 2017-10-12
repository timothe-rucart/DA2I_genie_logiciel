public class PileHanoi implements Pile<DisqueHanoi>{

    String nom ;
    int nbElements=0;
    DisqueHanoi[] tab = new DisqueHanoi[MAX_ELEMENTS];
    
    public PileHanoi(String s){
	nom = s;
    }
    
    public boolean vide(){
	return nbElements==0;
    }

    public boolean pleine(){
	return nbElements == MAX_ELEMENTS;
    }

    public boolean peutEmpiler(DisqueHanoi x){
	if(vide())
	    return true;
	else if(!vide() && !pleine() && x.diametre() < sommet().diametre())
	    return true;
	return false;
    }

    public DisqueHanoi sommet(){
	if(!vide()){
	    return tab[nbElements];
	}
	return null;
    }

    public DisqueHanoi depile(){
	if(!vide()){
	    DisqueHanoi d =sommet();
	    tab[nbElements]=null;
	    nbElements--;
	    return d;
	}
	return null;
    }

    public void empile(DisqueHanoi x){
	nbElements++;
	tab[nbElements]=x;
    }

    public void vider(){
	while(nbElements != 0){
	    depile();
	}
    }

    public int nbElements(){
	return nbElements;
    }

    public void deplacerUnElementVers(Pile<DisqueHanoi> p){
	DisqueHanoi e = depile();
	p.empile(e);
    }

    public String toString(){
	Affichage2 aff = new Affichage2();
	Disque[] disque = tab;
	return aff.affichage_tableau(disque,nbElements);
    }
}
