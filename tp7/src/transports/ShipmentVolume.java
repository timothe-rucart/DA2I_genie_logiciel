package transports;

public abstract class ShipmentVolume extends Shipment{
	
	int volume;
	
	public ShipmentVolume(int qteMax,  int volume) {
		super(qteMax, 80000);
		this.volume = volume;		
	}
	

    protected boolean isNotFull(Goods good){
	return qte+good.getVolume() < volume;
    }

    public void addQuantity(Goods good){
    	qte += good.getVolume();
    }
	
}
