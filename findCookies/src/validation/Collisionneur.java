package validation;

import objets.niveaux.graphiques.ObjetGraphique;

public class Collisionneur {
    /**
     * Vérifie si deux objets se collisionnent ou non
     * @param og1 Premier objet
     * @param og2 Second objet
     * @return vrai si les deux ont des collisions et se trouvent au même endroit ; faux sinon
     */
    public boolean presenceCollision(ObjetGraphique og1, ObjetGraphique og2){
        if(og1 == null || og2 == null) throw new IllegalArgumentException("L'objet graphique ne peut pas être null");

        if(!og1.getObjetMetier().getCollision() || !og2.getObjetMetier().getCollision()){
            return true;
        }
        return false;
    }
}
