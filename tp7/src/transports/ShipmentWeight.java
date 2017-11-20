package transports;

public abstract class ShipmentWeight extends Shipment{

	int weight;
	
	public ShipmentWeight(int qteMax, int distance, int weight) {
		super(qteMax, distance);
		this.weight = weight;
	}


    protected boolean isNotFull(Goods good){
    	return qte+good.getWeight() < weight;
    }

    public void addQuantity(Goods good){
    	qte += good.getWeight();
    }

}
