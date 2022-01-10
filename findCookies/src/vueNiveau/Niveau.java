package vueNiveau;

import metier.Couche;

import java.util.Collection;
import java.util.LinkedList;

public class Niveau {
    private int numeroNiveau;
    public int getNumeroNiveau() {
        return numeroNiveau;
    }
    public void setNumeroNiveau(int numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
    }

    private float hauteur;
    public float getHauteur() {
        return hauteur;
    }
    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    private float largeur;
    public float getLargeur() {
        return largeur;
    }
    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    private Collection<Couche> listeCouches;
    public Collection<Couche> getListeCouches() {
        return listeCouches;
    }
    public void setListeCouches(Collection<Couche> listeCouches) {
        this.listeCouches = listeCouches;
    }

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Niveau(int numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = 500;
        this.largeur = 500;
        this.listeCouches = new LinkedList<>();
    }

    public Niveau(int numeroNiveau, float hauteur, float largeur) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = new LinkedList<>();
    }

    public Niveau(int numeroNiveau, float hauteur, float largeur, Collection<Couche> listeCouches) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = listeCouches;
    }

    public Niveau(int numeroNiveau, Collection<Couche> listeCouches) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = 500;
        this.largeur = 500;
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
        String message = "\nNiveau numero " + numeroNiveau +
                '\n';

        message = message + "\tNiveau de hauteur=" + hauteur +
                ", largeur=" + largeur + "\n";
        for (Couche c : listeCouches) {
            message += c;
        }

        return message;
    }
}



