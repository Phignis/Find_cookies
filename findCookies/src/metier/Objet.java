package metier;// métier.Objet représente un objet possédant une intéractivitée

public abstract class Objet {
    private String uri_image;
    private float hauteur;
    private float largeur;
    private float posX;
    private float posY;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Objet(String uri_image, float hauteur, float largeur, float posX, float posY) {
        this.uri_image = uri_image;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.posX = posX;
        this.posY = posY;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public String getUri_image() {
        return uri_image;
    }

    public float getHauteur() {
        return hauteur;
    }

    public float getLargeur() {
        return largeur;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }


    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setUri_Image(String uri_image) {
        this.uri_image = uri_image;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public String toString() {
        return "\t\t\tmétier.Objet\n"
                + "image= " + uri_image + '\'' +
                ", hauteur=" + hauteur +
                ", largeur=" + largeur +
                ", posX=" + posX +
                ", posY=" + posY;
    }
}
