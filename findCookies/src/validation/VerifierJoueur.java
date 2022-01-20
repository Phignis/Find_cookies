package validation;

import objets.niveaux.Joueur;
import java.util.List;

public class VerifierJoueur {
    /**
     * Vérifie si le pseudo donné en paramètre correspond à un joueur de la liste ou non
     * @param pseudo Pseudo du joueur
     * @param listeJoueurs Liste des joueurs de l'application
     * @return vrai si le pseudo correspond à un joueur dans la liste ; faux sinon
     */
    public boolean verifierPseudo(String pseudo, List<Joueur> listeJoueurs){
        if(!pseudo.isEmpty() && !pseudo.isBlank()){
            return true;
        }

        for(Joueur j : listeJoueurs){
            if(j.getPseudo().equals(pseudo)){
                return false;
            }
        }

        return false;
    }
}
