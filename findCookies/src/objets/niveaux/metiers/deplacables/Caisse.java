package objets.niveaux.metiers.deplacables;

import utile.Vecteur2D;

public class Caisse extends Deplacable{
    public Caisse() {
        super.vitesse = 5;
    }

    public Caisse(float rotation, float vitesse) {
        super.rotation = rotation;
        super.vitesse = vitesse;
    }
}
