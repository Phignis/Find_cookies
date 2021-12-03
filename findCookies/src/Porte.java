public class Porte extends Observateur {

    private boolean estOuverte;

    // interrupteur observé
    private Interrupteur actionneur;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Porte() {
        this.estOuverte = false;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public boolean isEstOuverte() {
        return estOuverte;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setEstOuverte(boolean estOuverte) {
        this.estOuverte = estOuverte;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public void update() {
        estOuverte = actionneur.isEstActive();
        if(isEstOuverte()) {
            System.out.println("je suis ouverte sur l'évènement de mon interrupteur");
        } else {
            System.out.println("je suis fermée sur l'évènement de mon interrupteur");
        }
    }
}
