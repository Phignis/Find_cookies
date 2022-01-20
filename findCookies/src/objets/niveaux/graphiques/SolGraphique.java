package objets.niveaux.graphiques;

import objets.niveaux.metiers.ObjetMetier;
import objets.niveaux.metiers.Sol;
import objets.niveaux.metiers.deplacables.Deplacable;
import objets.niveaux.metiers.deplacables.Personnage;

public class SolGraphique extends ObjetGraphique {
    private Sol sol;

    public SolGraphique(float posX, float posY, Sol sol) throws Exception {
        super("sol_3.jpg", posX, posY);
        this.sol = sol;
    }

    @Override
    public ObjetMetier getObjetMetier() {
        return sol;
    }
}
