// représente une grille, un layout d'objet du jeu
package metier;

import java.util.Collection;
import java.util.LinkedList;

public class Couche {
    private int numCouche;

    private Collection<ObjetGraphique> listeObjets;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Couche(int numCouche) {
        this.numCouche = numCouche;
        this.listeObjets = new LinkedList<>();
    }

    public Couche(int numCouche, Collection<ObjetGraphique> listeObjets){
        this.numCouche = numCouche;
        this.listeObjets = listeObjets;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public int getNumCouche() {
        return numCouche;
    }

    public Collection<ObjetGraphique> getListeObjets() {
        return listeObjets;
    }


    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setNumCouche(int numCouche) {
        this.numCouche = numCouche;
    }

    public void setListeObjets(Collection<ObjetGraphique> listeObjets) {
        this.listeObjets = listeObjets;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    public boolean ajouterObjet(ObjetGraphique o) {
        return listeObjets.add(o);
    }

    public boolean supprimerObjet(ObjetGraphique o) {
        return listeObjets.remove(o);
    }

    @Override
    public String toString() {
        String message = "\t\tCouche numéro : " + numCouche + ", objets à l'intérieur :\n ";
        for(ObjetGraphique o: listeObjets) {
            message += o.toString() + '\n';
        }

        return message;
    }
}
