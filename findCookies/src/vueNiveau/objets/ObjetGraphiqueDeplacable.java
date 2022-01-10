package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.deplacables.Deplacable;

public abstract class ObjetGraphiqueDeplacable extends ObjetGraphique {
    private float posX;
    private float posY;

    public ObjetGraphiqueDeplacable(String cheminImage, float posX, float posY) {
        super(cheminImage, posX, posY);
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosX(float posX){
        super.posX = posX;
    }

    public void setPosY(float posY){
        super.posY = posY;
    }


    @Override
    public ObjetMetier getObjetMetier() {
        return deplacable;
    }
}
