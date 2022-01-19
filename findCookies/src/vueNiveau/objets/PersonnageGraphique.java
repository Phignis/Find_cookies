package vueNiveau.objets;

import metier.objets.ObjetMetier;
import metier.objets.deplacables.Deplacable;
import metier.objets.deplacables.Personnage;

public class PersonnageGraphique extends ObjetGraphiqueDeplacable {

    private Personnage personnage;

    public PersonnageGraphique(float posX, float posY, Deplacable deplacable, Personnage personnage) {
        super("chpatata_arrete.png", posX, posY, deplacable);
        this.personnage = personnage;
    }

    @Override
    public ObjetMetier getObjetMetier() {
        return personnage;
    }
}
