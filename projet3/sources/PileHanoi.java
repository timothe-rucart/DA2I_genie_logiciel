import java.util.Stack;
public class PileHanoi implements Pile{

    int nbElement=0;
    Stack stack = new Stack();

    boolean vide(){
	return nbElement==0;}

    boolean pleine(){
	return nbElement == MAX_ELEMENTS;
    }

    boolean peutEmpiler(E x){
	return !pleine() && x.diametre() < sommet().diametre();
    }

    E sommet(){

    }

    E depile(){}

    void empile(E x){}

    void vider(){}

    int nbElements(){}

    void deplacerUnElementVers(Pile<E> p){}

    Stirng toString(){}
}
