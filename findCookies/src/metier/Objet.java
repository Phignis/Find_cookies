package metier;// métier.Objet représente un objet possédant une intéractivitée

public abstract class Objet {
    private String uri_image;
    private float posX;
    private float posY;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Objet(String uri_image, float posX, float posY) {
        this.uri_image = uri_image;
        this.posX = posX;
        this.posY = posY;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public String getUri_image() {
        return uri_image;
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
                ", posX=" + posX +
                ", posY=" + posY;
    }
}
