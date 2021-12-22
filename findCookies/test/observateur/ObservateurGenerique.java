package observateur;

import utile.observateur.Observateur;

public class ObservateurGenerique implements Observateur {
    // classe attendu seulement a fin de test de la clock ou de l'implémentation du patron Observateur,
    // ne servant qu'a fournir une classe concrète

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
    public void update(Class c) {
        activiteObservateur = !activiteObservateur;

        if(isActiviteObservateur()) System.out.println(getNomObservateur() + " est actif par l'action d'un " + c.getName());
        else System.out.println(getNomObservateur() + " est inactif sur l'action d'un " + c.getName());
    }
}
