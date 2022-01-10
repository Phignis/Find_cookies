package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.Porte;

public class PorteGraphique extends ObjetGraphique {

    private Porte porte;

    public PorteGraphique(float posX, float posY, Porte metier) {
        super("/images/porte_fermee.png", posX, posY);
        porte = metier;
    }

    public PorteGraphique(PorteGraphique p) {
        super(p);
        porte = new Porte(p.porte);
    }


    @Override
    public ObjetMetier getObjetMetier() {
        return porte;
    }
}
