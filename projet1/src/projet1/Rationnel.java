package projet1;

/**
 * 
 * @author rucartt
 *
 */

public class Rationnel {
	
	int a;
	int b;
	int n;
	
	public Rationnel(int n, int a, int b){
		this.n=n;
		//System.out.println("n: "+n+" a: "+a+" b: "+b);
		if(a<0 && b<0){			
			this.a=-a;
			this.b=-b;
		}	
		else if(a<0){			
			if(-a>b){				
				int cpt=0;
				a=-a;
				while(a>b){
					a-=b;					
					cpt++;
				}			
				this.n-=cpt;
				a-=b;
			}
			this.n-=1;
			this.a=b+a;
			this.b=b;						
		}

		else if(b<0){
			this.n-=1;
			this.b=-b;
			this.a=a+b;
		}
		else{
			this.a=a;
			this.b=b;
		}			
	} 
	
	public Rationnel(int n){		
		this(n,0,0);
	}
	
	public Rationnel(int a,int b){
		this(0,a,b);	
	}
	
	public boolean estNul(){
		return(n==0 && a==0 && b==0);
	}
	
	public String toString(){
		if(n==0)
			return (a+"/"+b);
		else if(a==0 || b==0)
			return (""+n);
		return (n+" + "+a+"/"+b);		
	}
	
	public Rationnel inverse(){
		int aB = b*n+a;
		int bB = b;
		int cpt=0;

		while(true){
			if(bB-aB>=0){
				bB-=aB;
				cpt++;
			}
			else
				break;
		}
		return new Rationnel(cpt,bB,aB);
		
	}
	
	public Rationnel ajouter(Rationnel r){
		int ar1=b*n+a;
		int br1=b;
		int ar2=r.b*r.n+r.a;
		int br2=r.b;
		
		int den = br1*br2;
		int num = ar1*br2 + ar2*br1;
		int cpt=0;
		while(true){
			if(num-den>=0){
				num-=den;
				cpt++;
			}
			else
				break;
		}
		
		return new Rationnel(cpt,num,den);		
	}
	
	public Rationnel multiplier(Rationnel r){
		int ar1=b*n+a;
		int br1=b;
		int ar2=r.b*r.n+r.a;
		int br2=r.b;
		
		int den=br1*br2;
		int num=ar1*ar2;
		
		int cpt=0;
		while(num-den>=0){
			num-=den;
			cpt++;						
		}
		
		return new Rationnel(cpt,num,den);
	}
	
	public int compareTo(Rationnel r){
		int rep = this.n-r.n;
		
		if(rep!=0){
			System.out.println("ok");
			return (rep<0)? -1 : 1;
		}
		else{
			if(this.a == r.a && this.b == r.b || this.a == r.a && this.a ==0)
				return 0;
			else{				
				double n1 = (double)this.a/(double)this.b;
				double n2 = (double)r.a/(double)r.b;				
				return (n1<n2)?-1:1;
			}
			
		}
	}
	
		
	public static void main(String[] args){			
        System.out.println(new Rationnel(-15,6)) ;

	} 
	
}
