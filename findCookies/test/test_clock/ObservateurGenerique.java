package test_clock;

import utile.observateur.Observateur;

public class ObservateurGenerique extends Observateur {
    // classe attendu seulement a fin de test de la clock, ne servant qu'a fournir une classe concrète

    private String nomObservateur;
    private boolean activiteObservateur;


    public ObservateurGenerique(String nomObservateur) {
        this.nomObservateur = nomObservateur;
        activiteObservateur = false;
    }

    public String getNomObservateur() {
        return nomObservateur;
    }

    public boolean isActiviteObservateur() {
        return activiteObservateur;
    }

    @Override
    public void update() {
        activiteObservateur = !activiteObservateur;

        if(isActiviteObservateur()) System.out.println(getNomObservateur() + " est actif!");
        else System.out.println(getNomObservateur() + " est inactif!");
    }

}
