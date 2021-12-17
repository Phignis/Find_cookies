package metier;

public abstract class Declencheur extends Objet {

    public Declencheur(String image, int posX, int posY) {
        super(image, posX, posY);
    }

    public abstract void effet();
}
