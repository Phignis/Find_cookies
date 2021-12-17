package metier;

import utile.observateur.Observateur;
import utile.observateur.Sujet;

public class Interrupteur extends Declencheur {

    private boolean estActive;
    private Sujet sujet;


    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    public Interrupteur(String image, int posX, int posY) {
        super(image, posX, posY);
        estActive = false;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public boolean isEstActive() {
        return estActive;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    public boolean attacherObserservateur(Observateur o) {
        return sujet.attacher(o);
    }

    public boolean detacherObservateur(Observateur o) {
        return sujet.detacher(o);
    }

    public void notifier() {
        sujet.notifier();
    }

    public void lorsqueActionne() {
        return; // changement du skin dans le futur
    }

    @Override
    public void effet() {
        return;
    }
}
