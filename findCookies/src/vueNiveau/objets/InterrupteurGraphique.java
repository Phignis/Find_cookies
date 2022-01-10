package vueNiveau.objets;

import metier.objets.Interrupteur;
import metier.objets.ObjetMetier;
import utile.observateur.Observateur;

public class InterrupteurGraphique extends ObjetGraphique {

    private Interrupteur interrupteur;

    public InterrupteurGraphique(float posX, float posY, Interrupteur metier) {
        super("/images/interrupteur_ferme.png", posX, posY);
        interrupteur = metier;
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

    @Override
    public ObjetMetier getObjetMetier() {
        return interrupteur;
    }

    @Override
    public ObjetGraphique creerSauvegardeEtat() {
        return new InterrupteurGraphique(getPosX(), getPosY(), interrupteur.creerSauvegardeEtat());
    }

}
