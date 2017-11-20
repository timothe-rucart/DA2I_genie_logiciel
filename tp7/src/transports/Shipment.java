package transports;

import java.util.ArrayList;

public abstract class Shipment {
				
	int distance;
	int qte = 0;
	final int QUANTITEMAX;
	ArrayList<Goods> marchandises;
	
	
	public Shipment(int qteMax, int distance){
		marchandises = new ArrayList<>();
		this.distance = distance;	
		QUANTITEMAX = qteMax;
	}
	
    protected abstract boolean isNotFull(Goods good);
    
    protected abstract void addQuantity(Goods good);    

    public abstract int cost();
    
	public void add(Goods good) throws IllegalStateException{
		if(isNotFull(good)){
		    marchandises.add(good);
		    addQuantity(good);
		    System.out.println("quantite " + qte);
		} else {
		    throw new IllegalStateException("Cargaison complète") ;
		}
    }
	
}