package objets.niveaux.graphiques;

import objets.niveaux.metiers.Interrupteur;
import objets.niveaux.metiers.ObjetMetier;
import observateurs.Observateur;

public class InterrupteurGraphique extends ObjetGraphique {

    private Interrupteur interrupteur;

    public InterrupteurGraphique(float posX, float posY, Interrupteur metier) throws Exception {
        super("bouton_rouge.png", posX, posY);
        interrupteur = metier;
    }

    public InterrupteurGraphique(InterrupteurGraphique i) throws Exception {
        super(i);
        interrupteur = new Interrupteur(i.interrupteur);
    }

    @Override
    public ObjetMetier getObjetMetier() {
        return interrupteur;
    }

    public void actionnerInterrupteur() {
        interrupteur.actionnerInterrupteur();
    }

    public boolean attacher(Observateur o) {
        return interrupteur.attacher(o);
    }

    public boolean detacher(Observateur o) {
        return interrupteur.detacher(o);
    }

    public void notifier() {
        interrupteur.notifier();
    }

}
