package tp4;

/** ICI les commentaires sur le fonctionnement de la classe */
public class TabDict<K,V> implements  Dictionnaire<K,V> //, Iterable<K>
{
    private static final int INIT_SIZE = 100 ;       // taille initiale du tableau
    private Couple<K,V> [] associations ;            // tableau contenant les associations
    private int nbAssoc ;	// nombre d'elements effectivement presents dans le dictionnaire

    /** Crée une instance de dictionnaire vide */
    public TabDict() {
        nbAssoc = 0 ;
        associations = (Couple<K,V>[]) new Couple[INIT_SIZE] ;
    }
    
    // redimensionnement automatique du tableau en une taille double
    private void resize() {
        Couple<K,V> [] asso = (Couple<K,V>[] )new Couple[associations.length*2];
        for(int i=0 ; i<associations.length ;i++){
        	asso[i]=associations[i];
        }
        associations=asso;
    }

    // ajoute une association à la première position libre (après avoir 
    // redimensionné le tableau si nécessaire)
    private void add(Couple<K,V> assoc) {

    	int cpt=0;
    	boolean estVide=false;
    	
    	while(!estVide && cpt<associations.length){
    		
    		if(associations[cpt]==null)
    			estVide=true; 		
    		else
    			cpt++;
    	}    
    	
    	if(estVide && cpt<associations.length){
    		associations[cpt]=assoc;
    	}
    	else if(!estVide){
    		resize();
    		associations[cpt]=assoc;
    	}
    	nbAssoc++;
    }

    // enlève l'association à l'indice spécifié
    void remove(int index) {
    	if(index != -1 && index<associations.length){
    		associations[index]=null;
    		nbAssoc--;
    	}
    }

    // indice de l'association assoc ; -1 si elle est absente 
    private int indexOf(Couple<K,V> assoc) {
       
    	int i=0;
    	 
    	while(i<associations.length){
    		if(associations[i] != null &&associations[i].premier().equals(assoc.premier()) && associations[i].second().equals(assoc.second()))
    			return i;
    		i++;
    	}
    	return -1;
    }
    
    // indice de l'association de clef c ; -1 si elle est absente
    private int indexOfClef(K c) {
         
    	int i=0;
    	while(i<associations.length){
    		if(associations[i]!= null && associations[i].premier().equals(c))
    			return i;
    		i++;
    	}
    	return -1;
    }

    // méthode nécessaire pour l'itérateur :
    // retourne la clef située à l'indice i, null si i incorrect
    K clefPourIndex(int i) {
    	if(i<associations.length && associations[i]!=null){
    		return associations[i].premier();
    	}
    	return null;
    }
    
    // IMPLÉMENTATION DE L'INTERFACE Dictionnaire
    

    // IMPLÉMENTATION DE L'INTERFACE Iterable (2e partie du TP)
    // /** Itérateur permettant de parcourir les clefs (et d'en supprimer) */
    // public Iterator<K> iterator() {
    //     return new DictIterator<K>(this) ;
    // }   
    
    public void afficherListe(){
    	for(int i=0 ; i<associations.length ;i++){
    		System.out.println(associations[i]+" - ");
    	}
    }

	@Override
	public boolean estVide() {		
		return nbAssoc==0;
	}

	
	public boolean contient(Couple<K, V> assoc) {	
		return indexOf(assoc)!=-1;
	}

	
	public boolean contientClef(K c) {		
		return indexOfClef(c)!=-1;
	}

	
	public boolean contientValeur(V v) {		
		for(Couple<K, V> co : associations){
			if(co != null && co.second().equals(v))
				return true;
		}
		return false;
	}

	
	public int nbElements() {		
		return nbAssoc;
	}


	public Couple<K, V> assocPour(K c) {
		if(indexOfClef(c)!= -1)
			return associations[indexOfClef(c)]; 
		return null;
	}


	public V valeurPour(K c) {
		if(assocPour(c)!= null)
			return associations[indexOfClef(c)].second();
		return null;
	}

	
	public void ajouter(Couple<K, V> assoc) {
		if(!contientClef(assoc.premier()))
			add(assoc);		
	}

	
	public void ajouter(K c, V v) {
		if(!contientClef(c))
			add(new CoupleObj(c,v));		
	}

	
	public void enlever(Couple<K, V> assoc) {		
		remove(indexOf(assoc));
	}

	
	public void enleverPour(K c) {		
		remove(indexOfClef(c));		
	}
	
	public String toString(){
		String res="";
		for(int i=0 ; i<associations.length ; i++){
			if(associations[i] != null)
				res+=associations[i]+" \n";
		}
		return res;
	}
	
	public static void main(String [] arg) {
        TabDict d = new TabDict() ;
        d.ajouter(new CoupleObj("Un entier", "sa racine carrée")) ;        
        for (int i=1; i<=10; i++)
            d.ajouter(i*i, i) ;        
        d.ajouter(new CoupleObj(2, "sqrt(2)")) ;             
        d.enleverPour(49) ;        
        d.ajouter(1, "lui-même") ;
        System.out.println(d) ;

        // CI-DESSOUS LES TESTS À RAJOUTER APRÈS AVOIR
        // IMPLÉMENTÉ DANS TabDict L'INTERFACE ITERABLE
        
        // Iterator it = d.iterator() ;
        // while (it.hasNext()) {
        //     Object o = it.next() ;
        //     System.out.println(o) ;
        //     if (o.equals(36)) {
        //         System.out.println("J'enlève "+o) ;
        //         it.remove() ;
        //     }
        // }
        // for (Object o: d) 
        //     System.out.println(d.assocPour(o)) ;
        
    }

}