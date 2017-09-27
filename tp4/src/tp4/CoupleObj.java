package tp4;

public class CoupleObj<K,V> implements Couple<K,V> {

	private K premier;
	private V deuxieme;
	
	CoupleObj(K prem, V deux){
		premier=prem;
		deuxieme=deux;
	}
	CoupleObj(){
		premier=null;
		deuxieme=null;
	}
	
	@Override
	public K premier() {		
		return premier;
	}

	@Override
	public V second() {
		return deuxieme;
	}

	@Override
	public void defPremier(K x) {
		premier=x;
	}

	@Override
	public void defSecond(V y) {
		deuxieme=y;
	}

	public String toString(){
		if(premier.equals(deuxieme))
			return premier+" -> lui meme";
		return (premier+" -> "+deuxieme);
	}
}
