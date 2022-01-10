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
    public String getCheminImage() {
        return cheminImage;
    }
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    protected float posX;
    public float getPosX() {
        return posX;
    }

    protected float posY;
    public float getPosY() {
        return posY;
    }

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public ObjetGraphique(String cheminImage, float posX, float posY, ObjetMetier metier) {
        this.cheminImage = cheminImage;
        this.posX = posX;
        this.posY = posY;
    }

    ////////////////////////////////
    // GETTER
    ////////////////////////////////

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
