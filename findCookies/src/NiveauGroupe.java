import java.util.Collection;
import java.util.LinkedList;

public class NiveauGroupe {
    private int numeroNiveau;
    private float hauteur;
    private float largeur;
    private Collection<Couche> listeCouches;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public NiveauGroupe(int numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = 500;
        this.largeur = 500;
        this.listeCouches = new LinkedList<>();
    }

    public NiveauGroupe(int numeroNiveau, float hauteur, float largeur) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = new LinkedList<>();
    }

    public NiveauGroupe(int numeroNiveau, float hauteur, float largeur, Collection<Couche> listeCouches) {
        this.numeroNiveau = numeroNiveau;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeCouches = listeCouches;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public int getNumeroNiveau() {
        return numeroNiveau;
    }

    public float getHauteur() {
        return hauteur;
    }

    public float getLargeur() {
        return largeur;
    }

    public Collection<Couche> getListeCouches() {
        return listeCouches;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setNumeroNiveau(int numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(float largeur) {
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



