package transports;

public class Air extends ShipmentVolume{

    public Air(int distance){
    	super(distance, 80000);
    }
    
    public int cost(){
    	return 10*distance + 4*qte;
    }
}
