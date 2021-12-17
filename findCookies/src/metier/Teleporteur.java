package metier;

public class Teleporteur{
    private int xDestination;
    private int yDestination;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Teleporteur(int xDestination, int yDestination) {
        this.xDestination = -1;
        this.yDestination = -1;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public boolean setDestination(int xDestination, int yDestination) {
        this.xDestination = xDestination;
        this.yDestination = yDestination;

        return true;
    }
}
