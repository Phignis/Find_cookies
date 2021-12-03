public class Teleporteur {
    private Teleporteur destination;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Teleporteur() {
        this.destination = null;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public boolean setDestination(Teleporteur destination) {
        // le téléporteur ne peut téléporter à lui même
        if(destination == this) {
            return false;
        }
        this.destination = destination;
        return true;
    }
}
