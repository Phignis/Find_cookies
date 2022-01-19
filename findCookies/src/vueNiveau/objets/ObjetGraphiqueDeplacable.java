package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.deplacables.Deplacable;

public abstract class ObjetGraphiqueDeplacable extends ObjetGraphique {

    public ObjetGraphiqueDeplacable(String cheminImage, float posX, float posY, Deplacable deplacable) {
        super(cheminImage, posX, posY);
    }

    public void setPosX(float posX){
        super.posX = posX;
    }

    public void setPosY(float posY){
        super.posY = posY;
    }
}
