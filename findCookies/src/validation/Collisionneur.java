package validation;

import vueNiveau.objets.ObjetGraphique;

import java.util.Collection;

public abstract class Collisionneur {
    public static boolean isEnCollision(ObjetGraphique og1, ObjetGraphique og2){
        if(og1 == null || og2 == null) throw new IllegalArgumentException("L'objet graphique ne peut pas être null");

        if(!og1.getObjetMetier().getCollision() || !og2.getObjetMetier().getCollision()){
            return true;
        }
        return false;
    }
}
