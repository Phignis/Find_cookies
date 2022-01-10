package vueNiveau.objets;

import metier.objets.Interrupteur;
import utile.observateur.Observateur;

public class InterrupteurGraphique extends ObjetGraphique {
    public InterrupteurGraphique(float posX, float posY, Interrupteur metier) {
        super("/images/objet_skin/interrupteur_ferme.png", posX, posY, metier);
    }

    public void actionnerInterrupteur() {
        ((Interrupteur) metier).actionnerInterrupteur();
    }

    public boolean attacher(Observateur o) {
        return ((Interrupteur) metier).attacher(o);
    }

    public boolean detacher(Observateur o) {
        return ((Interrupteur) metier).detacher(o);
    }

    public void notifier() {
        ((Interrupteur) metier).notifier();
    }
}
