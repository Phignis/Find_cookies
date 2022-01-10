package metier.objets;

import validation.Collisionneur;

public abstract class ObjetMetier {
    protected boolean collision = false;

    public boolean getCollision(){ return collision; }
}

