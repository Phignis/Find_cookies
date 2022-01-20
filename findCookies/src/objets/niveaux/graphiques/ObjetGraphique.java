package objets.niveaux.graphiques;

import javafx.scene.image.Image;
import objets.niveaux.metiers.ObjetMetier;
import utile.Vecteur2D;

import java.net.URL;

public abstract class ObjetGraphique {
    private String cheminImage;
    public String getCheminImage(){ return cheminImage; }
    public void setCheminImage(String cheminImage) throws Exception {
        URL ressource = getClass().getResource("/images/objet_skin/" + cheminImage);
        if(ressource == null){
            cheminImage = "skin_par_defaut.png";
        }

        ressource = getClass().getResource("/images/objet_skin/" + cheminImage);
        if(ressource == null){ throw new Exception("/images/objet_skin/skin_par_defaut.png n'existe pas"); }

        this.cheminImage = cheminImage;
        setImage(ressource);
    }

    private Image image;
    public Image getImage(){ return image; }
    private void setImage(URL cheminRessource) {
        image = new Image(cheminRessource.toExternalForm());
    }

    protected Vecteur2D vecteur2D;
    public float getPosX() {
        return vecteur2D.getX();
    }

    public float getPosY() {
        return vecteur2D.getY();
    }

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public ObjetGraphique(String cheminImage, float posX, float posY) throws Exception {
        setCheminImage(cheminImage);
        vecteur2D = new Vecteur2D(posX, posY);
    }

    protected ObjetGraphique(ObjetGraphique g) throws Exception {
        setCheminImage(g.getCheminImage());
        vecteur2D = new Vecteur2D(g.getPosX(), g.getPosY());
    }

    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public abstract ObjetMetier getObjetMetier();

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public String toString() {
        return "\tObjet graphique : \n"
                + "image= " + cheminImage + '\'' +
                ", posX=" + vecteur2D.getX() +
                ", posY=" + vecteur2D.getY();
    }
}
