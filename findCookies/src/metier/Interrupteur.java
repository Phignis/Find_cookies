package metier;

import utile.observateur.Observateur;
import utile.observateur.SujetAbstract;

public class Interrupteur extends Objet {

    private boolean estActive;
    private SujetAbstract sujet;


    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    public Interrupteur(String image, int posX, int posY) {
        super(image, posX, posY);
        estActive = false;
        sujet = null;
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
}
