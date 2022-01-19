package utile.accesPublique;

import objets.niveaux.Joueur;

public abstract class JoueurCourant {
    private static Joueur joueurCourant = null;
    public static Joueur getJoueurCourant(){ return joueurCourant; }
}
