package objets.niveaux.graphiques;

import objets.niveaux.metiers.deplacables.Caisse;
import objets.niveaux.metiers.deplacables.Deplacable;
import objets.niveaux.metiers.deplacables.Personnage;

public class CaisseGraphique extends ObjetGraphiqueDeplacable{
    private Caisse caisse;

    public CaisseGraphique(float posX, float posY, Caisse caisse) throws Exception {
        super("carton.png", posX, posY, caisse);
        this.caisse = caisse;
    }

    public CaisseGraphique(CaisseGraphique caisseGraphique) throws Exception {
        super(caisseGraphique.getCheminImage(), caisseGraphique.getPosX(), caisseGraphique.getPosY(), caisseGraphique.getObjetMetier());
        caisse = (Caisse) caisseGraphique.getObjetMetier();
    }

    @Override
    public Deplacable getObjetMetier() {
        return caisse;
    }
}
