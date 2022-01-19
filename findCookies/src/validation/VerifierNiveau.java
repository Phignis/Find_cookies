package validation;

import objets.niveaux.Joueur;

public class VerifierNiveau {

    /**
     * Vérifie le numéro de niveau demandé
     * @param j Joueur qui fait la requête du niveau
     * @param numeroDemande Numéro du niveau demandé
     * @return vrai si le numéro est bien accessible par ce joueur, faux sinon
     */
    public boolean verifierNumeroNiveau(Joueur j, int numeroDemande){
        if(j == null) throw new IllegalArgumentException("Le joueur ne peut pas être nul");
        if(j.getNiveauAtteint().getNumeroNiveau() >= numeroDemande && numeroDemande >= 0){
            return true;
        }
        return false;
    }
}
