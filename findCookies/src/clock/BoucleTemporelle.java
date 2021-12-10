package clock;

public class BoucleTemporelle extends Subject implements Runnable {
    private long nbSecondesBoucle;
    private long tempsEcoule;
    private Thread threadInterne;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public BoucleTemporelle(long nbSecondesBoucle) {
        this.nbSecondesBoucle = nbSecondesBoucle;
        tempsEcoule = 0;
        threadInterne = new Thread(this);
        threadInterne.start();
    }


    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setTempsTotalBoucle(long nbSecondesBoucle) {
        this.nbSecondesBoucle = nbSecondesBoucle;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    private boolean estBoucleTermine() {
        return nbSecondesBoucle == tempsEcoule;
    }

    private void eventFinDeBoucle() {
        if (estBoucleTermine()) {
            super.notifier();
            tempsEcoule = 0;
        }
    }

    @Override
    public void run() {
        // boucle du thread
        while (true) {
            try {
                Thread.sleep(1000); // wait d'une seconde
                ++tempsEcoule;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            eventFinDeBoucle();
        }
    }
}
