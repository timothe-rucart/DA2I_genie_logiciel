package transports;

public class Fluvial extends ShipmentWeight{

	public Fluvial(int qteMax, int weight) {
		super(qteMax, 30000, weight);
	}

	
	public int cost() {
		return (int) distance*(int)Math.sqrt(qte);
		
	}	

}