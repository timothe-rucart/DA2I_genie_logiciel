package calculatrice2;

public enum Operation2 {
    PLUS("+",2), MOINS("-",2), FOIS("*",2), DIV("/",2), PUISS("^",2), SQRT("V",1), ABS("ABS",1), NOT("NOT",1), IF("IF",3)  ;
	
	private final String code_operation;
	public final int arite;
	
	Operation2(String code, int arite){
		this.code_operation = code;
		this.arite = arite;
	}
	
	public String toString(){
		return code_operation;
	}
	
	public Double eval(Double[] operandes){
		switch (this){
	
			case FOIS :	return (operandes[0]*operandes[1]);
		
			case DIV : 	return (operandes[0]/operandes[1]);
		
			case MOINS : return (operandes[0] - operandes[1]);
		
			case PLUS: 	return (operandes[0] + operandes[1]);
		
			case PUISS : return Math.pow(operandes[0],operandes[1]);
			
			case SQRT : return Math.sqrt(operandes[0]);
			
			case ABS : return Math.abs(operandes[0]);
			
			case NOT : return operandes[0] == 0 ? 1.0 : 0;
					
			case IF : return operandes[0] != 0 ? operandes[1] : operandes[2];						
			
			default : return null;
	
		}
	}
}