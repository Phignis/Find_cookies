package objets.niveaux.metiers.deplacables;

import objets.niveaux.metiers.ObjetMetier;
import utile.Vecteur2D;

public abstract class Deplacable extends ObjetMetier {
    protected float vitesse;
    protected float rotation = 0;
    protected final boolean collision = true;

    public float getVitesse(){
        return vitesse;
    }
    public float getRotation(){
        return rotation;
    }
}
