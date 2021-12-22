package controleurs;

import managers.ManagerJoueur;
import metier.Joueur;
import validation.VerifierJoueur;
import java.util.ArrayList;
import java.util.List;

public class JoueurControleur {
    private Joueur joueurCourant;
    private ManagerJoueur managerJ = new ManagerJoueur();
    private VerifierJoueur verifierJ = new VerifierJoueur();
    private List<Joueur> listeJoueurs = new ArrayList<>();

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public boolean ajouterJoueur(String pseudo) throws Exception {
        boolean verif = verifierJ.verifierPseudo(pseudo, listeJoueurs);
        if(!verif){
            return false;
        }

        Joueur j = new Joueur(pseudo, 1);

        return managerJ.ajouterJoueur(j, listeJoueurs);
    }

}
