package vueNiveau.objets;

import javafx.scene.image.Image;
import metier.objets.ObjetMetier;

import java.net.URISyntaxException;
import java.net.URL;

/**
 * Objet graphique de l'application
 *
 * @version 1.0
 *
 * @author L'HOSTIS Loriane
 */
public abstract class ObjetGraphique {
    protected String cheminImage;
    private Image image;

    protected float posX;
    protected float posY;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public ObjetGraphique(String cheminImage, float posX, float posY) {
        URL ressource = getClass().getResource("/image/objet_skin/" + cheminImage);
        if(ressource == null){
            cheminImage = "sol_1.png";
        }
        this.cheminImage = cheminImage;
        image = new Image(ressource.toExternalForm());

        this.posX = posX;
        this.posY = posY;
    }

    protected ObjetGraphique(ObjetGraphique g) {
        URL ressource;
        ressource = getClass().getResource("/image/objet_skin/" + g.cheminImage);
        if(ressource == null){
            g.cheminImage = "default_skin.png";
        }
        this.cheminImage = g.cheminImage;
        image = new Image(ressource.toExternalForm());

        this.posX = g.posX;
        this.posY = g.posY;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public String getCheminImage() {
        return cheminImage;
    }
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public abstract ObjetMetier getObjetMetier();

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public String toString() {
        return "\t\t\tmétier.Objet\n"
                + "image= " + cheminImage + '\'' +
                ", posX=" + posX +
                ", posY=" + posY;
    }
}
