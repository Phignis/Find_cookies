public abstract class Declancheur extends Objet {

    public Declancheur(String image, int hauteur, int largeur, int posX, int posY) {
        super(image, hauteur, largeur, posX, posY);
    }

    public abstract void effet();
}
