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

    /**
     * permet de générer un objet du même type, dans le même état que cet objet à l'instant où est effectué la méthode
     * @return l'objet généré, ObjetGraphique
     */
    public abstract ObjetGraphique creerSauvegardeEtat();

    @Override
    public String toString() {
        return "\t\t\tmétier.Objet\n"
                + "image= " + cheminImage + '\'' +
                ", posX=" + posX +
                ", posY=" + posY;
    }
}
