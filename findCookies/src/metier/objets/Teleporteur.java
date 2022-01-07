package metier.objets;

public class Teleporteur{
    private float xDestination;
    private float yDestination;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Teleporteur(float xDestination, float yDestination) {
        this.xDestination = 0;
        this.yDestination = 0;
    }

    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public float getXDestination() { return xDestination; }

    public float getYDestination() { return yDestination; }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public boolean setDestination(float xDestination, float yDestination) {
        this.xDestination = xDestination;
        this.yDestination = yDestination;

        return true;
    }
}
