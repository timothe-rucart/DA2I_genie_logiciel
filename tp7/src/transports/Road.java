package transports;

public class Road extends ShipmentWeight{

	public Road(int qteMax, int weight) {
		super(qteMax, 38000, weight);
		
	}

	public int cost() {
		return 4*distance*qte;
	}

}
