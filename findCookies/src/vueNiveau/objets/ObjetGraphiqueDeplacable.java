package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.deplacables.Deplacable;

public class ObjetGraphiqueDeplacable extends ObjetGraphique {
    private Deplacable deplacable;

    public ObjetGraphiqueDeplacable(String cheminImage, float posX, float posY, Deplacable deplacable) {
        super(cheminImage, posX, posY, deplacable);
        this.deplacable = deplacable;
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
