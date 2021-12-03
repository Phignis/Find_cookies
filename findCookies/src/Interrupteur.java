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

<<<<<<< HEAD
    public boolean attacherObserservateur(Observateur o) {
        return sujet.attacherObservateur(o);
    }
=======
    public void effet() {
>>>>>>> 046bd38fbd486a3e94244f2d2b8c70e9d6f8a8d4

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
