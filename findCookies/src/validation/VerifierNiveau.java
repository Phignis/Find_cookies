package validation;

import metier.Joueur;

public abstract class VerifierNiveau {
    public boolean verifierNumeroNiveau(Joueur j, int numeroDemande){
        if(j == null) throw new IllegalArgumentException("Le joueur ne peut pas être nul");
        if(j.getNiveauAtteint().getNumeroNiveau() >= numeroDemande){
            return true;
        }
        return false;
    }
}
