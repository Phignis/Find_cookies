package vueNiveau.objets;

import metier.objets.deplacables.Deplacable;

public class ObjetGraphiqueDeplacable extends ObjetGraphique {
    private float posX;
    private float posY;

    public ObjetGraphiqueDeplacable(String cheminImage, float posX, float posY, Deplacable metier) {
        super(cheminImage, posX, posY, metier);
        this.posX = posX;
        this.posY = posY;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setPosX(float posX) { this.posX = posX; }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}
