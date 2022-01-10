package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.Porte;

public class PorteGraphique extends ObjetGraphique {

    private Porte p;

    public PorteGraphique(float posX, float posY, Porte metier) {
        super("/images/porte_fermee.png", posX, posY, metier);
        p = metier;
    }


    @Override
    public ObjetMetier getObjetMetier() {
        return null;
    }
}
