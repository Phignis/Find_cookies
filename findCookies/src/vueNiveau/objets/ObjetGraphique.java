package vueNiveau.objets;

import metier.objets.ObjetMetier;

/**
 * Objet graphique de l'application
 *
 * @version 1.0
 *
 * @author L'HOSTIS Loriane
 */
public abstract class ObjetGraphique {
    private String cheminImage;
    private float posX;
    private float posY;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public ObjetGraphique(String cheminImage, float posX, float posY) {
        this.cheminImage = cheminImage;
        this.posX = posX;
        this.posY = posY;
    }

    protected ObjetGraphique(ObjetGraphique g) {
        this.cheminImage = g.cheminImage;
        this.posX = g.posX;
        this.posY = g.posY;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public String getCheminImage() {
        return cheminImage;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public abstract ObjetMetier getObjetMetier();

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

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
