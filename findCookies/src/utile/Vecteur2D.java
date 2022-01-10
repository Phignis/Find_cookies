package utile;

public class Vecteur2D {
    private float x;
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    private float y;
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public Vecteur2D(float x, float y) {
        setX(x);
        setY(y);
    }

    public Vecteur2D(Vecteur2D other) {
        setX(other.x);
        setY(other.y);
    }

    /**
     * Additionner le vecteur instancié avec un autre vecteur
     * Par exemple : Pour modifier la position
     * @param autre Vecteur avec lequel le vecteur instancié s'additonnne
     * @return un nouveau vecteur résultant de la multiplication des vecteurs
     */
    public Vecteur2D additionner(Vecteur2D autre) {
        if(autre == null) throw new IllegalArgumentException("Le Vecteur2D ne peut pas être nul.");
        return new Vecteur2D(getX() + autre.getX(), getY() + autre.getY());
    }

    /**
     * Permet de multiplier le vecteur par un coefficient.
     * Par exemple : Permet d'appliquer une vitesse sur un vecteur avec mouvement = direction normalisée * vitesse
     * @param coefficient coefficient par lequel multiplier le vecteur
     * @return un nouveau vecteur
     */
    public Vecteur2D multiplier(float coefficient) {
        return new Vecteur2D(getX() * coefficient, getY() * coefficient);
    }

    /**
     * Obtenir la longueur du vecteur
     * @return la longueur du vecteur
     */
    public float getLongueur() {
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * Normalise sur une échelle 1 un vecteur
     * @return un nouveau vecteur normalisé
     */
    public Vecteur2D normaliser() {
        return new Vecteur2D(getX() / getLongueur(), getY() / getLongueur());
    }

    /**
     * Créé un vecteur de coordonnées (0,0)
     * @return un nouveau vecteur de coordonnées (0,0)
     */
    public static Vecteur2D zero() {
        return new Vecteur2D(0,0);
    }
}
