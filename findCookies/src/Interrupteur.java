public class Interrupteur extends Declancheur {

    private boolean estActive;
    private Sujet sujet;


    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    public Interrupteur() {
        super();
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
        return sujet.attacherObservateur(o);
    }

    public boolean detacherObservateur(Observateur o) {
        return sujet.detacherObservateur(o);
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
