package metier.objets.deplacables;

import utile.Vecteur2D;

public class Personnage extends Deplacable {
    public Personnage(){
        super.vitesse = 5;
        super.rotation = 5;
        super.vecteur2D = new Vecteur2D(2, 5);
    }
}
