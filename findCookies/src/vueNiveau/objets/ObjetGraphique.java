package vueNiveau.objets;

import javafx.scene.image.Image;
import metier.objets.ObjetMetier;

/**
 * Objet graphique de l'application
 *
 * @version 1.0
 *
 * @author L'HOSTIS Loriane
 */
public class ObjetGraphique {
    private Image image;
    private int posX;
    private int posY;
    protected ObjetMetier metier;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public ObjetGraphique(String cheminImage, int posX, int posY, ObjetMetier metier) {
        this.image = new Image(cheminImage);
        this.posX = posX;
        this.posY = posY;
        this.metier = metier;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public Image getImage() {
        return image;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public ObjetMetier getObjetMetier() { return metier; }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setCheminImage(String cheminImage) {
        this.image = new Image(cheminImage);
    }

    public void setObjetMetier(ObjetMetier metier) { this.metier = metier; }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public String toString() {
        return "\t\t\tmétier.Objet\n"
                + "image= " + image.toString() + '\'' +
                ", posX=" + posX +
                ", posY=" + posY;
    }
}
