package vueNiveau.objets;

import metier.objets.Porte;

public class PorteGraphique extends ObjetGraphique {
    public PorteGraphique(float posX, float posY, Porte metier) {
        super("/images/porte_fermee.png", posX, posY, metier);
    }


}
