package transports;

public class AirUrgent extends Air{

	public AirUrgent(int distance) {
		super(distance);
		
	}
    
    public int cost(){
    	return 10*distance + 4*qte;
    }
    
}