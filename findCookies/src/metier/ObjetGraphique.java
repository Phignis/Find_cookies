package metier;

import metier.objets.ObjetMetier;

/**
 * Objet graphique de l'application
 *
 * @version 1.0
 *
 * @author L'HOSTIS Loriane
 */

public class ObjetGraphique {
    private String cheminImage;
    private float posX;
    private float posY;
    private ObjetMetier metier;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public ObjetGraphique(String cheminImage, float posX, float posY, ObjetMetier metier) {
        this.cheminImage = cheminImage;
        this.posX = posX;
        this.posY = posY;
        this.metier = metier;
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

    public ObjetMetier getObjetMetier() { return metier; }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public void setObjetMetier(ObjetMetier metier) { this.metier = metier; }

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
