package calculatrice;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("*"), DIV("/"), PUISS("^") ;
	
	private final String code_operation;
	
	Operation(String code){
		this.code_operation = code;
	}
	
	public String toString(){
		return code_operation;
	}
	
	public Double eval(double x, double y){
		
		switch (this){
			case FOIS : return (x*y);
			
			case DIV : return (x/y);
			
			case MOINS : return (x-y);
			
			case PLUS: return (x+y);
			
			case PUISS : return Math.pow(x, y);
			
			default : return null;
		}
	}
}
