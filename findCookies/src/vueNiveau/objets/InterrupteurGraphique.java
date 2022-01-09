package vueNiveau.objets;

import metier.objets.Interrupteur;
import utile.observateur.Observateur;

public class InterrupteurGraphique extends ObjetGraphique {
    public InterrupteurGraphique(String cheminImage, float posX, float posY, Interrupteur metier) {
        super(cheminImage, posX, posY, metier);
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
