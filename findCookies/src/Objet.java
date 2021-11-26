// Objet représente un objet possédant une intéractivitée

public class Objet {

    private String image;
    private int hauteur;
    private int largeur;
    private int posX;
    private int posY;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Objet(String image, int hauteur, int largeur, int posX, int posY) {
        this.image = image;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.posX = posX;
        this.posY = posY;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public String getImage() {
        return image;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setImage(String image) {
        this.image = image;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public String toString() {
        return "\t\t\tObjet '" + image + '\'' +
                ", hauteur=" + hauteur +
                ", largeur=" + largeur +
                ", posX=" + posX +
                ", posY=" + posY;
    }
}
