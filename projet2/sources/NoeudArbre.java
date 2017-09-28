import java.util.Scanner;

public class NoeudArbre{

    String contenu;
    NoeudArbre positif, negatif;
        
    NoeudArbre(String contenu){
        this.contenu = contenu;
        positif = null;
        negatif = null;
    }
    
    NoeudArbre(String contenu, NoeudArbre n1, NoeudArbre n2){
        this.contenu=contenu;
        positif = n2;
        negatif = n1;
    }
    
    public int examiner(String reponse){
        if(reponse.equals("oui")){
            return 1;
        }
        else if(reponse.equals("non"))
            return -1;
        else{
            System.out.println("Reponse non connu du systeme, veuillez repondre oui ou non");
            return 0;
        }
    }
    
    public void rechercherAnimal(){
        System.out.println(contenu);
        
        Scanner sc = new Scanner(System.in);
        String repUtilisateur = sc.nextLine();
        
        int i = examiner(repUtilisateur);
        if(i==0)
            rechercherAnimal();
        
        if(i==1){
            if(positif!=null)
                positif.rechercherAnimal();
            else
                System.out.println("Trouve !");
        }
        else if(i==-1){
            if(negatif!=null){
                negatif.rechercherAnimal();
            }
            else{
                questionNouvelAnimal();
            }
        }
    }
    
    public void questionNouvelAnimal(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Qu'est ce que c'est ?");
        String nouvelAnimal = sc.nextLine();
        System.out.println(nouvelAnimal+"  ! Je ne connais pas cet animal. Donnez-moi une question qui permette de différencier "+nouvelAnimal +" d’"+contenu);
        String nouvelleQuestion = sc.nextLine();
        System.out.println("Quelle doit etre la reponse pour "+nouvelAnimal+"?");
        String nouvelleReponse = sc.nextLine();
        
        if(nouvelleReponse.equals("non")){
            negatif = new NoeudArbre(nouvelAnimal);
            positif = new NoeudArbre(contenu);
        }
        else if(nouvelleReponse.equals("oui")){
            positif = new NoeudArbre(nouvelAnimal);
            negatif = new NoeudArbre(contenu);
        }
        
        contenu = nouvelleQuestion;
    }
    
    public String toString(){
        String res = "\""+contenu+"\" ";
        
        if(negatif !=null)
            res += negatif+" ";
        if(positif != null)
            res += positif+" ";
        
        return res;     
    }
    
    public String definir(String animal){
        
        String rep = contenu + " ";
	   if(negatif == null){
	       if(contenu.equals(animal)){
               return contenu;
           } else {
               return "";
	       }    
	   }

	if(negatif != null){
	    String rep2 =  negatif.definir(animal);
	    if(!rep2.equals("")){
		rep+= " non => " + rep2;
	    }
	}
	
	if(positif != null && !rep.contains(animal)){
	    String rep2 =  positif.definir(animal);
	    if(!rep2.equals("")){
		rep+= " oui => " + rep2;
	    }
	}
	
	return rep;
    }
    
    
    public static void main(String [] args){
        NoeudArbre arbre;        
         
        if(args.length>0 && args[0].equals("--definir")){            
            arbre = new NoeudArbre("est ce un mammifere?", new NoeudArbre("un croco"), new NoeudArbre("un cheval"));
            System.out.println(arbre.definir(args[1]));
        }
        else{
             if(args.length == 0){      
                arbre = new NoeudArbre("est ce un mammifere?", new NoeudArbre("un croco"), new NoeudArbre("Est-ce qu'il aboie?",new NoeudArbre("un cheval"),new NoeudArbre("un chien")));
          }
            else{
                arbre = new NoeudArbre(args[0], new NoeudArbre(args[2]),new NoeudArbre(args[1]));        
            }
                Scanner sc = new Scanner(System.in);
                boolean continuer = true;

                while(continuer){
                    arbre.rechercherAnimal();
                    System.out.println("Voulez-vous rejouer?");            

                    if(sc.nextLine().equals("non"))
                        continuer = false;                    
            }  
        }          
        System.out.println(arbre);
    }        
}