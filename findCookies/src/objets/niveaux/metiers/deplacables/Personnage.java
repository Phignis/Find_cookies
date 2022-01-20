package objets.niveaux.metiers.deplacables;

import utile.Vecteur2D;

public class Personnage extends Deplacable {
    public Personnage(){
        super.vitesse = 5;
    }

    public Personnage(float vitesse){
        super.vitesse = vitesse;
    }

}
