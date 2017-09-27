/**
 * @author Timothe Rucart
 * class Date
 */

public class Date
{
    // les attributs des instances
    private int jour, mois, annee ;
    // les attributs de la classe
    public static final String [] NOM_DES_MOIS =
    { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" } ;
    
    public static final String [] MOIS_ANGLAIS = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    public Date(int jour, int mois, int annee)
    {
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
    }
    
    public String toString()
    {
        return jour + " " + NOM_DES_MOIS[mois-1] + " " + annee ;
    }

    public static void main(String [] arg){

	int jour,mois,annee;

	String var = arg[0];

	if(arg[0].equals("-francais") || arg[0].equals("-anglais")){
	
	    /** on met une valeur dans les variables **/
	    System.out.println("Entrez un jour :");
	    jour = Clavier.readInt();
	
	    System.out.println("Entrez un mois :");
	    mois = Clavier.readInt();
	
	    System.out.println("Entrez un annee :");
	    annee = Clavier.readInt();

	    Date d = new Date(jour,mois,annee);

	    if(var.equals("-francais")){
		/** On affiche les valeurs de l'utilisateur en Francais**/
		System.out.println(d.jour+" "+NOM_DES_MOIS[d.mois]+" "+d.annee);
	    }
	    else if(var.equals("-anglais")){
		/** On affiche les valeurs de l'utilisateur en Anglais**/
		System.out.println(d.jour+" "+MOIS_ANGLAIS[d.mois]+" "+d.annee);
	    }
	    else {

	    }
	}
	else {
	    System.out.println("Langue inconnue");
	}
	    
    }
}
