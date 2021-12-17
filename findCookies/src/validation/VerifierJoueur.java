package validation;

import metier.Joueur;
import java.util.List;

public class VerifierJoueur {
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
