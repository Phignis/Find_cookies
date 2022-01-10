package metier.objets.deplacables;

import metier.objets.ObjetMetier;
import utile.Vecteur2D;

public abstract class Deplacable extends ObjetMetier {
    protected float vitesse;
    protected float rotation;
    protected Vecteur2D vecteur2D;

    protected boolean collision = true;

    public float getVitesse(){
        return vitesse;
    }

    public float getRotation(){
        return rotation;
    }

    public Vecteur2D getPosition(){
        return vecteur2D;
    }
}
