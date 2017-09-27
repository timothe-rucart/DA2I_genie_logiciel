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
        positif = n1;
        negatif = n2;
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
        System.out.println("Est-ce "+contenu);
        
        Scanner sc = new Scanner(System.in);
        String repUtilisateur = sc.nextLine();
        
        int i = examiner(repUtilisateur);
        
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
        
        
        
        
    /*
        if(i==1 ){
         
            if(positif==null){                
                System.out.println("Est-ce "+positif.contenu+"?");  
            
                repUtilisateur = sc.nextLine();
                i = examiner(repUtilisateur);
                
                if(i==1)
                    System.out.println("Trouvé ! Fin");
                else
                    questionNouvelAnimal();
            }
            else
                positif.rechercherAnimal();
        }
        
        
        else if(i==-1){
        
            if(negatif==null){
                System.out.println("Est ce "+negatif.contenu+"?");
                repUtilisateur = sc.nextLine();
                i = examiner(repUtilisateur);
                if(i==1)
                    System.out.println("Trouvé ! Fin");
                else
                    questionNouvelAnimal();
            }
            else{
                negatif.rechercherAnimal();
            }
        }*/

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
        //return ("\"Est ce "+contenu+"?\" \""+negatif+"\" \""+positif+"\"");
    }
    
    public static void main(String [] args){
        NoeudArbre arbre = new NoeudArbre(args[0], new NoeudArbre(args[2]),new NoeudArbre(args[1]));        
        
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;
        while(continuer){
            arbre.rechercherAnimal();
            System.out.println("Voulez-vous rejouer?");            
            
            if(sc.nextLine().equals("non"))
                continuer = false;
            System.out.println(arbre);
        }    
    }        
}