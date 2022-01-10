package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.Porte;

public class PorteGraphique extends ObjetGraphique {

    private Porte porte;

    public PorteGraphique(float posX, float posY, Porte metier) {
        super("/images/porte_fermee.png", posX, posY);
        porte = metier;
    }


    @Override
    public ObjetMetier getObjetMetier() {
        return porte;
    }

    @Override
    public ObjetGraphique creerSauvegardeEtat() {
        return new PorteGraphique(getPosX(), getPosY(), porte.creerSauvegardeEtat());
    }
}
