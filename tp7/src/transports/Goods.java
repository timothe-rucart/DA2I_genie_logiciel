package transports;

public class Goods {

	
	private int weight;
	private int volume;
	
	Goods(int weight, int volume){
		this.weight = weight;
		this.volume = volume;
	}
	
	public int getWeight(){
		return weight;		
	}
	
	public int getVolume(){
		return volume;
	}
	
	
}
