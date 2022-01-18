package manageurs;

import metier.Joueur;

import java.util.List;

public class ManageurJoueur {

    public boolean ajouterJoueur(Joueur j, List<Joueur> listeJoueurs) throws Exception {
        return listeJoueurs.add(j);
    }
}
