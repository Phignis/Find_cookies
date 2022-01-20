package controleurs;

import manageurs.ManageurJoueur;
import metier.Joueur;
import validation.VerifierJoueur;
import java.util.ArrayList;
import java.util.List;

public class JoueurControleur {
    private Joueur joueurCourant;
    private ManageurJoueur managerJ = new ManageurJoueur();
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
