public abstract class Declencheur extends Objet {

    public Declencheur(String image, int hauteur, int largeur, int posX, int posY) {
        super(image, hauteur, largeur, posX, posY);
    }

    public abstract void effet();
}
