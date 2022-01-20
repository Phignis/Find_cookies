package objets.niveaux.metiers;

public class Teleporteur{
    /**
     * Destination sur l'axe des X
     */
    private float xDestination;
    public float getXDestination() { return xDestination; }

    /**
     * Destination sur l'axe des Y
     */
    private float yDestination;
    public float getYDestination() { return yDestination; }

    /**
     * Changer la destination
     * @param xDestination Destination sur l'axe des X
     * @param yDestination Destination sur l'axe des Y
     */
    public void setDestination(float xDestination, float yDestination) {
        this.xDestination = xDestination;
        this.yDestination = yDestination;
    }

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Teleporteur(float xDestination, float yDestination) {
        this.xDestination = 0;
        this.yDestination = 0;
    }


}
