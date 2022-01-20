package objets.niveaux.graphiques;

import objets.niveaux.metiers.ObjetMetier;
import objets.niveaux.metiers.ObjetVide;

public class ObjetVideGraphique extends ObjetGraphique {
    private ObjetVide objetVide;

    public ObjetVideGraphique(float posX, float posY, ObjetVide objetVide) throws Exception {
        super("skin_par_defaut.png", posX, posY);
        this.objetVide = objetVide;
    }

    @Override
    public ObjetMetier getObjetMetier() {
        return objetVide;
    }
}
