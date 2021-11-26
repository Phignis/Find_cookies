// la scene représente une ensemble de couches l'un au dessus de l'autre

import java.util.Collection;
import java.util.LinkedList;

public class Scene {
    private int hauteur;
    private int largeur;
    private Collection<Couche> listeCouches;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Scene(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = new LinkedList<>();
    }

    public Scene(int hauteur, int largeur, Collection<Couche> listeCouches) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = listeCouches;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public Collection<Couche> getListeCouches() {
        return listeCouches;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setListeCouches(Collection<Couche> listeCouches) {
        this.listeCouches = listeCouches;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    public boolean ajouterCouche(Couche c) {
        return listeCouches.add(c);
    }

    public boolean enleverCouche(Couche c) {
        return listeCouches.remove(c);
    }

    @Override
    public String toString() {
        String message = "\tScene de hauteur=" + hauteur +
                ", largeur=" + largeur;
        for(Couche c: listeCouches) {
            message += c;
        }

        return message;
    }
}
