package image;
import dictionnaire.*;
public class ImageDict implements ImageGrise{  
    
    private int largeur, hauteur;
    TabDict<String,String> tab = new TabDict<>();

    /** Retourne la largeur de l'image */
    public int largeur(){
        return largeur;
    }
    
    /** Retourne la hauteur de l'image */
    public int hauteur(){
        return hauteur;
    }
    
    /** Retourne le niveau de gris du point de coordonnées (x,y) */
    public NiveauGris pointEn(int x, int y) {
        Point p  = new Point(x,y);
        if(tab.contientClef(p))
            return (NiveauGris)tab.valeurPour(p);
        return NiveauGris.BLANC;
    }
    
    /** Fixe le niveau de gris du point de coordonnées (x,y) à la valeur spécifiée */
    public void definirPoint(int x, int y, NiveauGris gris){
        Point p = new Point(x,y);
        tab.ajouter(p,gris);
        
    }
        
    /** Met en noir le point de coordonnées (x,y) */
    public void allumer(int x, int y){
        if(!tab.contientClef(new Point(x,y)))
            tab.ajouter(new Point(x,y),NiveauGris.NOIR);
    }
    
    /** Met en blanc le point de coordonnées (x,y) */
    public void eteindre(int x, int y){
        if(!tab.contientClef(new Point(x,y)))
            tab.ajouter(new Point(x,y),NiveauGris.BLANC);
    }
    
    /** Donne une valeur aléatoire (noir ou blanc) à chaque point de l'image */
    public void randomize(){        
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
                NiveauGris nivGris = NiveauGris.randomizeNB();
                tab.ajouter(new Point(x,y),nivGris);
            }
        }                        
    }
    
    /** Compte le nombre de points de l'image dont le niveau de gris est égal au niveau spécifié */
    public int compterPoints(NiveauGris gris){
        int cpt = 0;
        Iterator iter = tab.iterator();
        while(iter.hasNext()){
            if(tab.valeurPour(iter.next()).equals(gris))
                cpt++;
        }
        return cpt;
    }
    
    /** Retourne une image qui est le négatif de l'image courante */
    public ImageGrise inverser(){
        /*ImageGrise newImg = new ImageTab(largeur, hauteur);

        for(int i=0; i < largeur ; i++){
            for(int j=0; j < hauteur ; j++){
                if(dict.contientClef(new Point(i, j))){
                    newImg.definirPoint(i, j, ((NiveauGris) dict.valeurPour(new Point(i, j))).inverser());
                } else {  
                    newImg.definirPoint(i, j, NiveauGris.BLANC.inverser());
                }
            }
        }
        return newImg;*/
        Iterator iter = tab.iterator();
        while(iter.hasNext()){
            Object o = iter.next();            
            if(tab.contient(o)){
                int index = tab.indexOf(o);
                NiveauGris ng = tab.valeurPour(tab.clefPourIndex(index));
                
            }
        }
    }
    
    /** Retourne une image dont tous les points (sauf blancs) sont un niveau
     * plus clair que dans l'image courante */
    public ImageGrise eclaircir(){
        ImageGrise img = new ImageTab(largeur,hauteur);
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
                if(!tab[i][j].estBlanc())
                    img.definirPoint(i,j,tab[i][j].eclaircir());                
                else
                    img.definirPoint(i,j,tab[i][j]);
            }
        }
        return img;
    }
        
    /** Retourne une image dont tous les points (sauf noirs) sont un niveau
     * plus foncé que dans l'image courante */
    public ImageGrise assombrir(){
         ImageGrise img = new ImageTab(largeur,hauteur);
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
                if(!tab[i][j].estNoir())
                    img.definirPoint(i,j,tab[i][j].assombrir());      
                else
                    img.definirPoint(i,j,tab[i][j]);      
            }
        }
        return img;
    }
        
        
    /** Retourne une <B>copie</B> de l'image courante */
    public ImageGrise dupliquer(){
        ImageGrise img = new ImageTab(largeur, hauteur);
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
            img.definirPoint(i,j,tab[i][j]);
            }
        }
        return img;
    }
        
        
    /** Retourne une image en additionnant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) */
    public ImageGrise ajouter(ImageGrise img){
        ImageGrise img2 = new ImageTab(largeur,hauteur);
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
                img2.definirPoint(i,j,tab[i][j].ajouter(img.pointEn(i,j)));
            }
        }
        return img2;
    }
    
    
    /** Retourne une image en retranchant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) */
    public ImageGrise soustraire(ImageGrise img){
        ImageGrise img2 = new ImageTab(largeur,hauteur);
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
                img2.definirPoint(i,j,tab[i][j].soustraire(img.pointEn(i,j)));
            }
        }
        return img2;
    }
    
    
    /** Retourne une image en faisant un OU Exclusif (XOR) point par
     * point les niveaux de gris de l'image courante et de l'image en
     * paramètre (les deux images doivent être de même taille) */
    public ImageGrise XOR(ImageGrise img){
        if(img.hauteur() == hauteur && img.largeur() == largeur){
            ImageGrise img2 = new ImageTab(largeur,hauteur);
            for(int i=0 ; i<hauteur ; i++){
                for(int j=0 ; j<largeur ; j++){
                    img2.definirPoint(i,j,tab[i][j].XOR(img.pointEn(i,j)));
                }
            }
            return img2;
        }
        return null;
    }
    
    /** Retourne une image qui représente "l'intersection" de l'image courante et de l'image 
     * en paramètre : seuls les points qui ont le même niveau de gris dans les deux images sont
     * conservés (les deux images doivent être de même taille) */
    public ImageGrise intersection(ImageGrise img){
        if(img.hauteur() == hauteur && img.largeur() == largeur){
            ImageGrise img2 = new ImageTab(largeur,hauteur);    
            for(int i=0 ; i<hauteur ; i++){
                for(int j=0 ; j<largeur ; j++){
                    if(tab[i][j].equals(img.pointEn(i,j)))
                        img2.definirPoint(i,j,tab[i][j]);
                }
            }
            return img2;
        }
        return null;                        
    }
    
    
    /** Retourne le niveau de gris moyen de l'image. Pour le calculer, il faut faire la 
     * moyenne des niveaux de chaque point de l'image (ce qui revient à compter combien il y
     * a de points de chaque niveau de gris possible) */
    public NiveauGris niveauMoyen(){
        int n=0;
        for(int i=0 ; i<hauteur ; i++){
            for(int j=0 ; j<largeur ; j++){
                n+=tab[i][j].ordinal();
            }
        }
        n = n/(largeur*hauteur);        
        return NiveauGris.deNiveau(n);
    }
   


    public ImageGrise augmenterContraste(){
        ImageGrise newImg = new ImageTab(largeur, hauteur);
        NiveauGris grisMoyen = this.niveauMoyen();

        for(int i=0; i < largeur ; i++){
            for(int j=0; j < hauteur ; j++){
                if (tab[i][j].compareTo(grisMoyen) <= 0){
                    newImg.definirPoint(i, j, tab[i][j].eclaircir());
                } else {
                    newImg.definirPoint(i, j, tab[i][j].assombrir());
                }
            }
        }
        return newImg;
    } 
}