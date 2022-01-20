package objets.niveaux;

import java.util.ArrayList;

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

    private ArrayList<Couche> listeCouches;
    public ArrayList<Couche> getListeCouches() {
        return listeCouches;
    }
    public void setListeCouches(ArrayList<Couche> listeCouches) {
        this.listeCouches = listeCouches;
    }

    public final int NB_COUCHES = 4;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Niveau(int numeroNiveau) {
        if(numeroNiveau<=0){ throw new IllegalArgumentException("Le numéro de niveau doit être supérieure à 0"); }

        this.numeroNiveau = numeroNiveau;
        this.hauteur = 500;
        this.largeur = 500;
        this.listeCouches = new ArrayList<Couche>();
    }

    public Niveau(int numeroNiveau, float hauteur, float largeur) {
        if(numeroNiveau<=0){ throw new IllegalArgumentException("Le numéro de niveau doit être supérieure à 0"); }
        if(hauteur<=0){ throw new IllegalArgumentException("La hauteur doit être supérieure à 0"); }
        if(largeur<=0){ throw new IllegalArgumentException("La largeur doit être supérieure à 0"); }

        this.numeroNiveau = numeroNiveau;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = new ArrayList<Couche>();
    }

    public Niveau(int numeroNiveau, float hauteur, float largeur, ArrayList<Couche> listeCouches) {
        if(numeroNiveau<=0){ throw new IllegalArgumentException("Le numéro de niveau doit être supérieure à 0"); }
        if(hauteur<=0){ throw new IllegalArgumentException("La hauteur doit être supérieure à 0"); }
        if(largeur<=0){ throw new IllegalArgumentException("La largeur doit être supérieure à 0"); }
        if(listeCouches.stream().count() > NB_COUCHES || listeCouches == null){
            throw new IllegalArgumentException("Le nombre de couches doit être inférieur ou égal à " + NB_COUCHES);
        }

        this.numeroNiveau = numeroNiveau;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = listeCouches;
    }

    public Niveau(int numeroNiveau, ArrayList<Couche> listeCouches) {
        if(numeroNiveau<=0){ throw new IllegalArgumentException("Le numéro de niveau doit être supérieure à 0"); }
        if(listeCouches.stream().count() > NB_COUCHES || listeCouches == null){
            throw new IllegalArgumentException("Le nombre de couches doit être inférieur ou égal à " + NB_COUCHES);
        }

        this.numeroNiveau = numeroNiveau;
        this.hauteur = 500;
        this.largeur = 500;
        this.listeCouches = listeCouches;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    public boolean ajouterCouche(Couche c) {
        if(listeCouches.stream().count() + 1 >= NB_COUCHES){
            return false;
        }
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



