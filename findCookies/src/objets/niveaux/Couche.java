// représente une grille, un layout d'objet du jeu
package objets.niveaux;

import objets.niveaux.graphiques.ObjetGraphique;

import java.util.ArrayList;

public class Couche {
    /**
     * Numéro de la couche courante
     */
    private int numCouche;
    public int getNumCouche() {
        return numCouche;
    }
    public void setNumCouche(int numCouche) {
        this.numCouche = numCouche;
    }

    /**
     * Liste des objets graphiques de l'application et pour la couche courante
     */
    private ArrayList<ObjetGraphique> listeObjets;
    public ArrayList<ObjetGraphique> getListeObjets() { return listeObjets; }
    public void setListeObjets(ArrayList<ObjetGraphique> listeObjets) {
        this.listeObjets = listeObjets;
    }


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Couche(int numCouche) {
        this.numCouche = numCouche;
        this.listeObjets = new ArrayList<ObjetGraphique>();
    }

    public Couche(int numCouche, ArrayList<ObjetGraphique> listeObjets){
        this.numCouche = numCouche;
        this.listeObjets = listeObjets;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Ajoute un objet graphique à la liste des objets graphiques
     * @param o Objet graphique à ajouter
     * @return vrai si l'objet a bien été ajouté, faux sinon
     */
    public boolean ajouterObjet(ObjetGraphique o) {
        return listeObjets.add(o);
    }

    /**
     * Supprime un objet graphique à la liste des objets graphiques
     * @param o Objet graphique à supprimer
     * @return vrai si l'objet a bien été supprimé, faux sinon
     */
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
