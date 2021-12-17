package managers;

import metier.Joueur;

import java.util.List;

public class ManagerJoueur {

    public boolean ajouterJoueur(Joueur j, List<Joueur> listeJoueurs) throws Exception {
        return listeJoueurs.add(j);
    }
}
