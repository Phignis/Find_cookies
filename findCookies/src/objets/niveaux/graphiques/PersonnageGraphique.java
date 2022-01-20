package objets.niveaux.graphiques;

import objets.niveaux.metiers.deplacables.Caisse;
import objets.niveaux.metiers.deplacables.Deplacable;
import objets.niveaux.metiers.deplacables.Personnage;
import observateurs.Observateur;

public class PersonnageGraphique extends ObjetGraphiqueDeplacable{
    private Personnage personnage;

    public PersonnageGraphique(float posX, float posY, Personnage personnage) throws Exception {
        super("chpatata_face.png", posX, posY, personnage);
        this.personnage = personnage;
    }

    public PersonnageGraphique(PersonnageGraphique personnageGraphique) throws Exception {
        super(personnageGraphique.getCheminImage(), personnageGraphique.getPosX(), personnageGraphique.getPosY(), personnageGraphique.getObjetMetier());
         personnage = (Personnage) personnageGraphique.getObjetMetier();
    }

    @Override
    public Deplacable getObjetMetier() {
        return personnage;
    }
}
